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

/**
 * The package with unit test boilerplate for GAE local services. The use of these environment helper class is optional.
 * It's up to you if you prefer to write unit test with inheritance of xxEnvironment over composition. Otherwise feel free
 * write your own unit test class. Write your own unit test class as well if you haven't found desired service
 * configuration. These implementations may help you with construction and initialization of GAE local services.
 * <p/>
 * See: https://cloud.google.com/appengine/docs/java/tools/localunittesting
 */
package org.ctoolkit.test.appengine;