package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalCapabilitiesServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local capabilities service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class CapabilitiesServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalCapabilitiesServiceTestConfig config = new LocalCapabilitiesServiceTestConfig();

    public CapabilitiesServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
