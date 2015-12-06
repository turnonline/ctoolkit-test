package org.ctoolkit.test.guicy;

import com.google.guiceberry.GuiceBerryEnvMain;
import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.TestScoped;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Extend this class to provide more configuration:
 * <code><pre>
 * public class MyJettyServerEnvironment
 *        extends JettyServerEnvironment
 * {
 *   protected JettyServer provideJettyServer( @PortNumber int portNumber )
 *   {
 *       JettyServer jettyServer = new JettyServer( portNumber );
 *       jettyServer.context().addServlet(..);
 *       jettyServer.context().addFilter(..);
 *       ..
 *       .
 * <p/>
 *       return jettyServer;
 *   }
 * <p/>
 *   protected void configure()
 *   {
 *       super.configure();
 *       bind( MyInterface.class ).to( MyInterfaceBean.class );
 * <p/>
 *   }
 * }
 * <p/>
 * </pre>
 * </code>
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public class JettyServerEnvironment
        extends GuiceBerryModule
{
    @Provides
    @Singleton
    @PortNumber
    int getPortNumber()
    {
        return FreePortFinder.findFreePort();
    }

    @Provides
    @TestScoped
    WebDriver getWebDriver()
    {
        return new HtmlUnitDriver();
    }

    @Provides
    @Singleton
    protected JettyServer provideJettyServer( @PortNumber int portNumber )
    {
        return new JettyServer( portNumber );
    }

    @Override
    protected void configure()
    {
        super.configure();
        bind( GuiceBerryEnvMain.class ).to( JettyServerStarter.class );
    }

    private static final class JettyServerStarter
            implements GuiceBerryEnvMain
    {
        @Inject
        private JettyServer server;

        public void run()
        {
            // Starting a server should never be done in a @Provides method (or inside Provider's get).
            server.start();
        }
    }
}
