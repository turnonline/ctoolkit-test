package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalFileServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local file service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class FileServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalFileServiceTestConfig config = new LocalFileServiceTestConfig();

    public FileServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
