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
