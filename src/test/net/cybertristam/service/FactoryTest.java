package net.cybertristam.service;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Factory Tester.
 *
 * @author <Authors name>
 * @since <pre>03/29/2005</pre>
 * @version 1.0
 */
public class FactoryTest extends TestCase
{
    public FactoryTest(String name)
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

    public void testGetInstance() throws Exception
    {
        assertEquals(Factory.class, Factory.getInstance().getClass());
    }

    public void testGetService() throws Exception
    {
        FileStatisticsServiceImpl fss = new FileStatisticsServiceImpl();
        assertEquals(fss.getClass(), Factory.getInstance().getService("FileStatistics").getClass());
    }

    public static Test suite()
    {
        return new TestSuite(FactoryTest.class);
    }
}
