package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Config for accessing the local blobstore service in tests. Default behavior is to configure the local blobstore
 * to only store data in-memory and not write anything to disk. tearDown() wipes out all in-memory state so that the
 * blobstore is empty at the end of every test.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class BlobstoreServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalBlobstoreServiceTestConfig config = new LocalBlobstoreServiceTestConfig();

    public BlobstoreServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
