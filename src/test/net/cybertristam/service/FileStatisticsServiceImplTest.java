package net.cybertristam.service;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import net.cybertristam.dataObjects.Statistics;
import net.cybertristam.dataObjects.ServerStatistics;
import net.cybertristam.dataObjects.ConnectionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * FileStatisticsServiceImpl Tester.
 *
 * @author <Authors name>
 * @since <pre>03/29/2005</pre>
 * @version 1.0
 */
public class FileStatisticsServiceImplTest extends TestCase
{
    public FileStatisticsServiceImplTest(String name)
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

    public void testRetrieve() throws Exception
    {
        testSave();
        FileStatisticsServiceImpl fsi = new FileStatisticsServiceImpl();
        assertNotNull(fsi.retrieve("localhost"));
        //TODO: Test goes here...

    }

    public void testRetrieve1() throws Exception
    {
        FileStatisticsServiceImpl fsi = new FileStatisticsServiceImpl();
        assertNotNull(fsi.retrieve(new Integer(7),"TCP"));
        //TODO: Test goes here...
    }

    public void testRetrieve2() throws Exception
    {
        FileStatisticsServiceImpl fsi = new FileStatisticsServiceImpl();
        assertNotNull(fsi.retrieve("localhost",new Integer(7),"TCP"));
        //TODO: Test goes here...
    }

    public void testSave() throws Exception
    {
        FileStatisticsServiceImpl fsi = new FileStatisticsServiceImpl();
        Statistics stat = new ServerStatistics();
        stat.setAddress("localhost");
        stat.setPortNumber(new Integer(7));
        List statList = new ArrayList();
        ConnectionStatus cs = new ConnectionStatus();
        cs.setAddress("localhost");
        cs.setPortNumber("7");
        cs.setConnectionType("TCP");
        cs.setConnectionStartTime(new GregorianCalendar(TimeZone.getTimeZone("GMT")));
        cs.setConnectionEndTime(new GregorianCalendar(TimeZone.getTimeZone("GMT")));
        cs.setStatusType("CONNECTED");
        statList.add(cs);
        stat.setSockets(statList);
        assertTrue(fsi.save(stat));
        //TODO: Test goes here...
    }

    public static Test suite()
    {
        return new TestSuite(FileStatisticsServiceImplTest.class);
    }
}
