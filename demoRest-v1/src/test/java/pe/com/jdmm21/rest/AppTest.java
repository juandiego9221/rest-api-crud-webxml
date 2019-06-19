package pe.com.jdmm21.rest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pe.com.jdmm21.rest.router.RouteDefinition;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	public void testSimpleRoute() {
		RouteDefinition route = new RouteDefinition("GET /todos");
		
		assertTrue(route.matches("GET", "/todos"));
		assertTrue(!route.matches("POST", "/todos"));
		assertTrue(!route.matches("GET", "/todos/1"));

	}
	
	public void testSimpleRouteWithParameters() {
		RouteDefinition route = new RouteDefinition("POST /todos/:id");
//		
		assertTrue(route.matches("POST", "/todos/1"));
		assertTrue(route.matches("POST", "/todos/bar"));
		assertTrue(!route.matches("POST", "/todos/1/foo"));
		assertTrue(!route.matches("GET", "/todos/1"));
		assertTrue(!route.matches("POST", "/todos"));
		


	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
