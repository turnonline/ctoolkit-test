package org.ctoolkit.test.appengine;

import com.google.guiceberry.junit4.GuiceBerryRule;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Example test.
 * See more at <a href="https://cloud.google.com/appengine/docs/java/tools/localunittesting">Local Unit Testing for Java</a>
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public final class ExampleTest
        extends DatastoreServiceEnvironment
{
    @Rule
    public final GuiceBerryRule guiceBerry = new GuiceBerryRule( ExampleTest.class );

    @Inject
    private int number;

    @Override
    public void configureTestBinder()
    {
        bind( Integer.class ).toInstance( 100 );
    }

    @Test
    public void testHello() throws Exception
    {
        assertEquals( 100, number );
    }
}
