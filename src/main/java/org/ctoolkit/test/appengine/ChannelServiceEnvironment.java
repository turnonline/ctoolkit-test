package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalChannelServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local channel service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class ChannelServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalChannelServiceTestConfig config = new LocalChannelServiceTestConfig();

    public ChannelServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
