package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalImagesServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local images service in tests.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class ImagesServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalImagesServiceTestConfig config = new LocalImagesServiceTestConfig();

    public ImagesServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
