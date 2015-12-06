package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalMailServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local mail service in tests. tearDown() wipes out sent messages so that there is no state
 * passed between tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class MailServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalMailServiceTestConfig config = new LocalMailServiceTestConfig();

    public MailServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
