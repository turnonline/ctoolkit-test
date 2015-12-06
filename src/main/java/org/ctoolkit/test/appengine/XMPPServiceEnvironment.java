package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalXMPPServiceTestConfig;

/**
 * Config for accessing the local xmpp service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class XMPPServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalXMPPServiceTestConfig config = new LocalXMPPServiceTestConfig();

    public XMPPServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
