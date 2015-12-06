package org.ctoolkit.test.guicy;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
class FreePortFinder
{
    static int findFreePort()
    {
        for ( int i = 8000; i < 8100; i++ )
        {
            ServerSocket socket;
            try
            {
                socket = new ServerSocket( i );
                socket.close();
                return i;
            }
            catch ( IOException ignored )
            {
            }
        }
        throw new RuntimeException( "Can't find a free port" );
    }
}
