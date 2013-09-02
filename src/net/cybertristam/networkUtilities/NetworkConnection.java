/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 18, 2005
 * PROGRAM/FILENAME: net.cybertristam.networkUtilities.NetworkConnection
 * EXPLANATION: 
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 *     1           Mar 18, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */

package net.cybertristam.networkUtilities;


import java.net.*;
import net.cybertristam.dataObjects.ConnectionStatus;

public abstract class NetworkConnection implements INetworkConnection {
    private String address;
    private Integer portNumber;
    private Integer timeout;
    private ConnectionStatus status;

    public NetworkConnection() {
        setNetworkConnectionConfiguration("localhost",new Integer(7),new Integer(30));
    }

    public NetworkConnection(String address, Integer portNumber) {
        setNetworkConnectionConfiguration(address,portNumber,new Integer(30));
    }

    public NetworkConnection(String address, Integer portNumber, Integer timeout){
        setNetworkConnectionConfiguration(address,portNumber,timeout);
    }

    private void setNetworkConnectionConfiguration(String address, Integer portNumber,Integer timeout){
        setAddress(address);
        setPortNumber(portNumber);
        setTimeout(timeout);
    }

    public String getAddress(String address) {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public ConnectionStatus getStatus() {
        return status;
    }

    public void setStatus(ConnectionStatus status) {
        this.status = status;
    }

    public abstract void makeConnection();

    public void exceptionError(Exception ex) {
    }

}
