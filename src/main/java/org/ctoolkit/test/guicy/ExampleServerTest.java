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

package org.ctoolkit.test.guicy;

import com.google.guiceberry.junit4.GuiceBerryRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

/**
 * A demo test case to demonstrate usage.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public final class ExampleServerTest
{
    @Rule
    public GuiceBerryRule guiceBerry = new GuiceBerryRule( JettyServerEnvironment.class );

    @Inject
    private WebDriver driver;

    @Inject()
    @PortNumber()
    private int portNumber;

    @Test
    public void demo()
    {
        driver.get( "http://localhost:" + portNumber );
        // do something useful with WebElement element = driver.findElement(...) etc.
    }
}
