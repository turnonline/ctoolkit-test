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
