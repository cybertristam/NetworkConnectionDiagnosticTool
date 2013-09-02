package net.cybertristam.service;

import net.cybertristam.dataObjects.Statistics;
import net.cybertristam.exception.StatisticsRetrieveException;
import net.cybertristam.exception.StatisticsStoreException;

/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 28, 2005
 * PROGRAM/FILENAME: net.cybertristam.service.StatisticsService
 * EXPLANATION:
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 * 1           Mar 28, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */
public interface StatisticsService {
    public Statistics retrieve(String address) throws StatisticsRetrieveException;
    public Statistics retrieve(Integer portNumber, String Key) throws StatisticsRetrieveException;
    public Statistics retrieve(String address,Integer portNumber, String key) throws StatisticsRetrieveException;
    public void save(Statistics stat) throws StatisticsStoreException;
}
