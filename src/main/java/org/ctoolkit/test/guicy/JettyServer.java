package org.ctoolkit.test.guicy;

import com.google.inject.servlet.GuiceFilter;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.DefaultServlet;

import javax.inject.Inject;

/**
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public class JettyServer
{
    private final Server server;

    private final Context context;

    @Inject
    public JettyServer( int portNumber )
    {
        server = new Server( portNumber );
        context = new Context( server, "/", Context.SESSIONS );

        context.addFilter( GuiceFilter.class, "/*", 0 );
        context.addServlet( DefaultServlet.class, "/" );
    }

    public Context context()
    {
        return context;
    }

    public void start()
    {
        try
        {
            server.start();
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }
}
