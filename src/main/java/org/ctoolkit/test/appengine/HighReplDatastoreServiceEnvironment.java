/*
 *    Copyright 2015 Comvai, s.r.o.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.ctoolkit.test.appengine;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Maximum eventual consistency set (100).
 * <p/>
 * By setting the unapplied job percentage to 100, we are instructing the local datastore to operate with the maximum
 * amount of eventual consistency. Maximum eventual consistency means writes will commit but always fail to apply, so
 * global (non-ancestor) queries will consistently fail to see changes. This is of course not representative of the
 * amount of eventual consistency your application will see when running in production, but for testing purposes, it's
 * very useful to be able to configure the local datastore to behave this way every time. If you want more fine-grained
 * control over which transactions fail to apply, you can register your own HighRepJobPolicy:
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public abstract class HighReplDatastoreServiceEnvironment
        extends ServiceConfigModule
{
    protected final LocalDatastoreServiceTestConfig config = new LocalDatastoreServiceTestConfig()
            .setDefaultHighRepJobPolicyUnappliedJobPercentage( 100 );

    public HighReplDatastoreServiceEnvironment()
    {
        construct( new LocalServiceTestHelper( config ) );
    }
}
