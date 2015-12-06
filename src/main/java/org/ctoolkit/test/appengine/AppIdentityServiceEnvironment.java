package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalAppIdentityServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local app identity service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class AppIdentityServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalAppIdentityServiceTestConfig config = new LocalAppIdentityServiceTestConfig();

    public AppIdentityServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
