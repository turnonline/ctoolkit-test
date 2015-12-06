package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalURLFetchServiceTestConfig;

/**
 * Config for accessing the local url fetch service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class URLFetchServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalURLFetchServiceTestConfig config = new LocalURLFetchServiceTestConfig();

    public URLFetchServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
