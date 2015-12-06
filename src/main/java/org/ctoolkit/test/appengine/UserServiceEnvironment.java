package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

/**
 * Config for accessing the local user service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class UserServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalUserServiceTestConfig config = new LocalUserServiceTestConfig();

    public UserServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
