/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 16, 2005
 * PROGRAM/FILENAME: net.cybertristam.dataObjects.SocketStatistics
 * EXPLANATION:
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 * 1           Mar 16, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */


package net.cybertristam.dataObjects;

public abstract class SocketStatistics {
    
    private String socketType;
    private Integer portNumber;
    private String address;
    private ConnectionStatus statusOfConnection;

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public String getSocketType() {
        return this.socketType;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public Integer getPortNumber() {
        return this.portNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setStatusOfConnection(ConnectionStatus statusOfConnection) {
        this.statusOfConnection = statusOfConnection;
    }

    public ConnectionStatus getStatusOfConnection() {
        return this.statusOfConnection;
    }

}
