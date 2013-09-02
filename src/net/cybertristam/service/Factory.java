/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 28, 2005
 * PROGRAM/FILENAME: net.cybertristam.service.Factory
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

public class Factory {
    private static Factory factory = new Factory();
    //Read all the key properties from the properties file named for the SimpleName of this class.
    FilePropertiesReader properties = new FilePropertiesReader(this.getClass().getSimpleName());

    //Default Constructor
    private Factory() {
    }
    /**
     * This is the Interface to get the Singleton Instance of the Factory.
     * @return
     */
    public static Factory getInstance(){
        return factory;
    }

    /**
     * This is the method that returns the Implementation object that corresponds to the key and
     * is defined in the properties file.
     * @param key
     * @return
     */
    public Object getService(String key){
        Object objectToReturn = null;
        String keyName = properties.getProperty(key);
        try {
            Class classToReturn = Class.forName(keyName);
            objectToReturn = classToReturn.newInstance();
        }
        catch (InstantiationException ex) {
            exceptionError(ex);
        }
        catch (IllegalAccessException ex) {
            exceptionError(ex);
        }
        catch (ClassNotFoundException ex) {
            exceptionError(ex);
        }
        finally {
            return objectToReturn;
        }
    }

    /**
     * This is a method the handle all Exceptions thrown. It is public so that it can be overriden
     * to Support a different exception reporting system.
     * @param ex
     */
    public void exceptionError(Exception ex) {
        ex.printStackTrace();
    }
}
