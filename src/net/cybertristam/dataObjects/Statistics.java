/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 21, 2005
 * PROGRAM/FILENAME: net.cybertristam.dataObjects.Statistics
 * EXPLANATION:
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 *     1           Mar 21, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */

package net.cybertristam.dataObjects;

import java.util.List;

public abstract class Statistics {
    private String address; //This is the hostname/IP address.
    private Integer portNumber;
    private List sockets; //This is a Collection of SocketStatistics.

    public Statistics() {
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List getSockets() {
        return sockets;
    }

    public void setSockets(List sockets) {
        this.sockets = sockets;
    }
}
