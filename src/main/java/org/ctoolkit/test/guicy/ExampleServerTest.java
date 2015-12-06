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
