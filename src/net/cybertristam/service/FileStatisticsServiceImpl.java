/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 28, 2005
 * PROGRAM/FILENAME: net.cybertristam.service.FileStatisticsServiceImpl
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
import net.cybertristam.dataObjects.ConnectionStatus;
import net.cybertristam.exception.StatisticsRetrieveException;
import net.cybertristam.exception.StatisticsStoreException;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class FileStatisticsServiceImpl implements IStatisticsService {
    FilePropertiesReader fpr = new FilePropertiesReader("FileStatisticsService");

    public Statistics retrieve(String address) throws StatisticsRetrieveException {
        try {
            Statistics returnStatistics = new ServerStatistics();
            List sockets = new ArrayList();
            List tempSockets = new ArrayList();
            returnStatistics.setAddress(address);
            //Logic to find all connection stats files.
            List filenameList = getFilesInDir();
            filenameList = buildSubList(filenameList, address.toUpperCase());
            //Load all connection stats files into a collection.
            List connectionFiles = buildConnectionList(filenameList);
            //Load collection of address stats into server statistics
            returnStatistics.setSockets(connectionFiles);
            //Return server statistics
            return returnStatistics;
        } catch (Exception ex) {
            exceptionError(ex);
            return null;
        }
    }

    public Statistics retrieve(Integer portNumber, String key) throws StatisticsRetrieveException {
        try {
            Statistics returnStatistics = (Statistics) Factory.getInstance().getService(key);
            List sockets = new ArrayList();
            List tempSockets = new ArrayList();
            returnStatistics.setPortNumber(portNumber);
            returnStatistics.setPortNumber(portNumber);
            //Logic to find all connection stats files.
            List filenameList = getFilesInDir();
            filenameList = buildSubList(filenameList, portNumber.intValue() + key.toUpperCase());
            //Load all connection stats files into a collection.
            List connectionFiles = buildConnectionList(filenameList);
            //Load collection of address stats into server statistics
            returnStatistics.setSockets(connectionFiles);
            //Return server statistics
            return returnStatistics;
        } catch (Exception ex) {
            exceptionError(ex);
            return null;
        }
    }

    public Statistics retrieve(String address, Integer portNumber, String key) throws StatisticsRetrieveException {
        try {
            Statistics returnStatistics = (Statistics) Factory.getInstance().getService(key);
            List sockets = new ArrayList();
            List tempSockets = new ArrayList();
            returnStatistics.setAddress(address);
            returnStatistics.setPortNumber(portNumber);
            //Logic to find all connection stats files.
            List filenameList = getFilesInDir();
            filenameList = buildSubList(filenameList, address.toUpperCase() + portNumber.intValue() + key.toUpperCase());
            //Load all connection stats files into a collection.
            List connectionFiles = buildConnectionList(filenameList);
            //Load collection of address stats into server statistics
            returnStatistics.setSockets(connectionFiles);
            //Return server statistics
            return returnStatistics;
        } catch (Exception ex) {
            exceptionError(ex);
            return null;
        }
    }

    public Boolean save(Statistics stat) throws StatisticsStoreException {
        String filename = "default";
        String savePath = fpr.getProperty("SavePath");
        String fileSuffix = fpr.getProperty("FileSuffix");
        DateFormat dateFormat = new SimpleDateFormat(fpr.getProperty("DateFormat"));
        //Get the List of Sockets.
        List sockets = stat.getSockets();
        FileWriter fos;
        //Write the List of Sockets out as individual files.
        Iterator socketIterator = sockets.iterator();
        for (int i = 0; i < sockets.size(); i++) {
            ConnectionStatus socketToSave = (ConnectionStatus) socketIterator.next();
            String saveName = socketToSave.getAddress() + "-" + socketToSave.getPortNumber() + "_" + socketToSave.getConnectionType();
            String saveSuffix = "_" + dateFormat.format(socketToSave.getConnectionStartTime().getTime()) + "_" + dateFormat.format(socketToSave.getConnectionEndTime().getTime());
            filename = savePath + "/" + saveName + saveSuffix + "." + fileSuffix;
            try {
                fos = new FileWriter(filename);
                fos.write(socketToSave.toString());
                fos.flush();
                fos.close();
            } catch (IOException ex) {
                exceptionError(ex);
                return false;
            }
        }
        return true;
    }

    private List getFilesInDir() {
        String path = fpr.getProperty("DataPath");
        List returnList = new ArrayList();
        File fileDir = new File(path);
        File[] tempFile = fileDir.listFiles();
        for (int i = 0; i < tempFile.length; i++) {
            returnList.add(tempFile[i].getName());
        }
        return returnList;
    }

    private List buildSubList(List filenames, String nameSearch) {
        List returnList = new ArrayList();
        String tempName;
        Iterator filenameIterator = filenames.iterator();
        for (int i = 0; i < filenames.size(); i++) {
            tempName = (String) filenameIterator.next();
            if (tempName.contains(new StringBuffer(nameSearch).subSequence(0, nameSearch.length()))) {
                returnList.add(tempName);
            }
        }
        return returnList;
    }

    private List buildConnectionList(List filenames) {
        List returnList = new ArrayList();
        Iterator filenameIterator = filenames.iterator();
        for (int i = 0; i < filenames.size(); i++) {
            returnList.add(getConnectionFile((String) filenameIterator.next()));
        }
        return returnList;
    }

    private ConnectionStatus getConnectionFile(String filename) {
        ConnectionStatus returnStatus = new ConnectionStatus();
        FilePropertiesReader tempReader = new FilePropertiesReader(filename);
        returnStatus.setAddress(tempReader.getProperty("address"));
        returnStatus.setPortNumber(tempReader.getProperty("portNumber"));
        Calendar tempCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        tempCalendar.setTimeInMillis(new Long(tempReader.getProperty("connectionStartTime")).longValue());
        returnStatus.setConnectionStartTime(tempCalendar);
        tempCalendar.setTimeInMillis(new Long(tempReader.getProperty("connectionEndTime")).longValue());
        returnStatus.setConnectionEndTime(tempCalendar);
        returnStatus.setConnectionType(tempReader.getProperty("connectionType"));
        returnStatus.setStatusType(tempReader.getProperty("statusType"));
        return returnStatus;
    }

    public void exceptionError(Exception ex) {
        ex.printStackTrace();
    }
}
