package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.common.testing.TearDown;
import com.google.common.testing.TearDownAccepter;
import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.TestWrapper;
import com.google.inject.Provides;

/**
 * Guice Berry config service module.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class ServiceConfigModule
        extends GuiceBerryModule
{
    private LocalServiceTestHelper helper = new LocalServiceTestHelper();

    public void construct( LocalServiceTestHelper helper )
    {
        this.helper = helper;
    }

    @Override
    protected final void configure()
    {
        super.configure();
        configureTestBinder();
    }

    public abstract void configureTestBinder();

    @Provides
    TestWrapper getTestWrapper( final TearDownAccepter tearDownAccepter )
    {
        return new TestWrapper()
        {
            public void toRunBeforeTest()
            {
                helper.setUp();
                tearDownAccepter.addTearDown( new TearDown()
                {
                    public void tearDown() throws Exception
                    {
                        helper.tearDown();
                    }
                } );
            }
        };
    }
}
