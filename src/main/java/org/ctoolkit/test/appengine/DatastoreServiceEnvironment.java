package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


/**
 * Config for accessing the local datastore service in tests. Default behavior is to configure the local datastore
 * to only store data in-memory, to not write anything to disk, and for all jobs to apply on the first attempt
 * (master/slave consistency model). tearDown() wipes out all in-memory state so that the datastore is empty at the
 * end of every test.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class DatastoreServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalDatastoreServiceTestConfig config = new LocalDatastoreServiceTestConfig();

    public DatastoreServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
