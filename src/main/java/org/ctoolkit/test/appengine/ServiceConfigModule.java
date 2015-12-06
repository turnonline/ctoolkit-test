/*
 *    Copyright 2015 Comvai, s.r.o.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

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
