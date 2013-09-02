/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 28, 2005
 * PROGRAM/FILENAME: net.cybertristam.service.FileStatisticsService
 * EXPLANATION:
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 *     1           Mar 28, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */

package net.cybertristam.service;

import net.cybertristam.dataObjects.Statistics;
import net.cybertristam.dataObjects.ServerStatistics;
import net.cybertristam.dataObjects.PortStatistics;
import net.cybertristam.exception.StatisticsRetrieveException;
import net.cybertristam.exception.StatisticsStoreException;

public class FileStatisticsService implements StatisticsService {
    public Statistics retrieve(String address) throws StatisticsRetrieveException {
        return new ServerStatistics();
    }

    public Statistics retrieve(Integer portNumber,String key) throws StatisticsRetrieveException {
        Statistics returnStatistics = (Statistics) Factory.getInstance().getService(key);
        returnStatistics.setPortNumber(portNumber);
        return returnStatistics;
    }

    public Statistics retrieve(String address, Integer portNumber, String key) throws StatisticsRetrieveException {
        Statistics returnStatistics = (Statistics) Factory.getInstance().getService(key);
        returnStatistics.setAddress(address);
        returnStatistics.setPortNumber(portNumber);
        return returnStatistics;
    }

    public void save(Statistics stat) throws StatisticsStoreException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
