package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local memcache service in tests. tearDown() wipes out all cache entries so that memcache
 * is empty at the end of every test.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class MemcacheServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalMemcacheServiceTestConfig config = new LocalMemcacheServiceTestConfig();

    public MemcacheServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
