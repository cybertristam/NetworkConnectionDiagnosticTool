package net.cybertristam.dataObjects;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * ConnectionStatus Tester.
 *
 * @author <Authors name>
 * @since <pre>03/29/2005</pre>
 * @version 1.0
 */
public class ConnectionStatusTest extends TestCase
{
    public ConnectionStatusTest(String name)
    {
        super(name);
    }

    public void setUp() throws Exception
    {
        super.setUp();
    }

    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testGetAddress() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testSetAddress() throws Exception
    {
        //TODO: Test goes here...
        ConnectionStatus test = new ConnectionStatus();
        test.setAddress("localhost");
        test.setPortNumber("7");
        TimeZone tmz = TimeZone.getTimeZone("GMT");
        Calendar testCalendar = new GregorianCalendar(tmz);
        test.setConnectionStartTime(testCalendar);
        testCalendar = new GregorianCalendar(tmz);
        test.setConnectionEndTime(testCalendar);
        System.out.println("ConnectionStatus is: " +test.toString());
    }

    public void testGetPortNumber() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testSetPortNumber() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testSetConnectionStartTime() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testGetConnectionStartTime() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testSetStatusType() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testSetConnectionEndTime() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testGetConnectionEndTime() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testGetStatusType() throws Exception
    {
        //TODO: Test goes here...
    }

    public void testGetDurationInMilliSeconds() throws Exception
    {
        //TODO: Test goes here...
    }

    public static Test suite()
    {
        return new TestSuite(ConnectionStatusTest.class);
    }
}
