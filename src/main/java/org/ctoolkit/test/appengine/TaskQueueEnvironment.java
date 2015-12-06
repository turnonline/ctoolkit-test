package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;

/**
 * Config for accessing the local task queue in tests. Default behavior is to configure the local task queue to not
 * automatically execute any tasks. tearDown() wipes out all in-memory state so all queues are empty at the end of every
 * test.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class TaskQueueEnvironment
        extends ServiceConfigModule
{
    protected final LocalTaskQueueTestConfig config = new LocalTaskQueueTestConfig().setQueueXmlPath( "src/main/webapp/WEB-INF/queue.xml" );

    public TaskQueueEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
