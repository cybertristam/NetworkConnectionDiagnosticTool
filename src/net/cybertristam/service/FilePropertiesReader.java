package net.cybertristam.service;

import java.io.File;
import java.util.*;

/**
 * AUTHOR: Jon E. Wright
 * DATE/TIME: Feb 26, 2005 9:54:22 PM
 * PROGRAM/FILENAME: net.cybertristam.javautils.FilePropertiesReader
 * EXPLANATION: This Program Reads a Properties File and allows the programmer to access that data via the key value.
 * TEST DATA & EXPECTED RESULTS:
 * REVISION HISTORY (at a minimum note the version number - better to provide a summary of changes since the last submission)
 * VERSION NUMBER     DATE       AUTHOR
 *      1          02/26/2005  Jon E. Wright
 * REQUIREMENTS: The requirements are for this program to be given a Properties File, read the Properties Hash Map out
 * of the File, and then allow the data to be queried via the key value.
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */
public class FilePropertiesReader {
    //The Hash Map is stored as a Properties.
    Properties propertiesMap = new Properties();
    //A List of all the keys for the Hash Map/Properties.
    List listOfKeys = new ArrayList();
    //The name of the file where the Hash Map/Properties where read from.
    String filename;
    //A Resource Bundle for the File.
    ResourceBundle fileReader;

    /**
     * The Default Constructor.
     */
    public FilePropertiesReader(){
    }

    /**
     * A Constructor that takes the Filename as a String as the parameter. The name of the File is then set as the
     * filename from which the Hash Map/Properties are to be read from.
     * @param filename
     */
    public FilePropertiesReader(String filename){
        this.setPropertiesFilename(filename);
    }

    /**
     * A Constructor that takes the File as the parameter. The name of the File is then set as the
     * filename from which the Hash Map/Properties are to be read from.
     * @param file
     */
    public FilePropertiesReader(File file){
        this.setPropertiesFile(file);
    }

    /**
     * This method sets the filename by taking a string as a parameter. Once the filename is set, the FileReader
     * Resource Bundle is set equal to the Name passed to it, then the File is parsed and the Hash Map/Properties are
     * set in the propertiesMap.
     * @param filename
     */
    public void setPropertiesFilename(String filename){
        //Set the filename.
        this.filename = filename;
        //Set the Resource Bundle to the filename.
        this.setFileReader();
        //Read the Hash Map/Properties from the file into the propertiesMap.
        this.readPropertiesFile();
    }

    /**
     * This method sets the filename by taking the File as a parameter. Once the filename is set, the FileReader
     * Resource Bundle is set equal to the Name passed to it.
     * @param nameOfFile
     */
    public void setPropertiesFile(File nameOfFile){
        this.setPropertiesFilename(nameOfFile.getName());
    }

    /**
     * This method returns the filename which the Hash Map/Properties are associated with.
     * @return
     */
    public String getPropertiesFilename(){
        return this.filename;
    }

    /**
     * This method returns the File which with the Hash Map/Properties are associated with.
     * @return
     */
    public File getPropertiesFile(){
        return new File(filename);
    }

    /**
     * This method reads the Hash Map/Properties from the File, adds the key to List of Keys, then sets them in
     * propertiesMap.
     */
    private void readPropertiesFile(){
        //Clear List of Keys.
        listOfKeys.clear();
        //Get List of Keys from the Resource Bundle.
        Enumeration keys = fileReader.getKeys();
        //Set a Temp Variable for the name of the key.
        String key;
        //Set a Temp Variable for the String Data related to the Key in the Hash Map/Properties.
        String data;
        //Run Until there are no more keys (and related data).
        while(keys.hasMoreElements()){
            //Get the Next Key
            key = (String) keys.nextElement();
            //Add the Key to the List of Keys.
            listOfKeys.add(key);
            //Get the String Data related to the Key.
            data = this.getStringData(key);
            //Set the Hash Map/Properties with the key and corresponding data.
            this.setProperties(key, data );
        }
    }

    /**
     * This method sets the Resource Bundle.
     */
    private void setFileReader(){
        fileReader = ResourceBundle.getBundle(filename);
    }

    /**
     * This method returns the data value attached the key from the File.
     * @param key
     * @return
     */
    private String getStringData(String key){
        return fileReader.getString(key);
    }

    /**
     * This method sets the Hash Map/Properties in the propertiesMap.
     * @param key
     * @param data
     */
    private void setProperties(String key, String data){
        propertiesMap.setProperty(key,data);
    }

    /**
     * This method will return the data value attached to key from the Hash Map/Properties.
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName){
        return propertiesMap.getProperty(propertyName);
    }

    /**
     * This method returns the List of Keys as a Collection.
     * @return
     */
    public Collection getCollectionOfKeys(){
        return listOfKeys;
    }

    /**
     * This method returns the List of Keys as a List.
     * @return
     */
    public List getListOfKeys(){
        return listOfKeys;
    }

    /**
     * This method returns the List of Keys as an Array of Objects.
     * @return
     */
    public Object[] getArrayOfKeys(){
        return listOfKeys.toArray();
    }

    /**
     * This method returns the List of Keys as an Array of Strings.
     * @return
     */
    public String[] getStringArrayOfKeys(){
        return (String[]) listOfKeys.toArray(new String[listOfKeys.size()]);
    }
}

