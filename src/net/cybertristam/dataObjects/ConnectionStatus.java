/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 16, 2005
 * PROGRAM/FILENAME: net.cybertristam.dataObjects.ConnectionStatus
 * EXPLANATION: This Object Store Data on the Network Connection Status of the service (e.g. Up,
 * Down, or TimeOut)
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 *     1           Mar 16, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */

package net.cybertristam.dataObjects;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ConnectionStatus {
    private String address;
    private String portNumber;
    private String connectionType;
    private Calendar connectionStartTime;
    private Calendar connectionEndTime;
    private String statusType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.toUpperCase();
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType.toUpperCase();
    }

    public void setConnectionStartTime(Calendar connectionStartTime) {
        this.connectionStartTime = connectionStartTime;
    }

    public Calendar getConnectionStartTime() {
        return this.connectionStartTime;
    }
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public void setConnectionEndTime(Calendar connectionEndTime) {
        this.connectionEndTime = connectionEndTime;
    }

    public Calendar getConnectionEndTime() {
        return this.connectionEndTime;
    }

    public String getStatusType() {
        return this.statusType;
    }

    public Long getDurationInMilliSeconds(){
        return new Long(connectionEndTime.getTimeInMillis() - connectionStartTime.getTimeInMillis());
    }

    public String toString(){
        String returnAddress ="address = " + address + "\n";
        String returnPortNumber = "portNumber = " + portNumber + "\n";
        String returnConnectionType = "connectionType = " + connectionType + "\n";
        String returnStartTime = "connectionStartTime = " + connectionStartTime.getTimeInMillis() + "\n";
        String returnEndTime = "connectionEndTime = " + connectionEndTime.getTimeInMillis() + "\n";
        String returnStatusType = "statusType = " + statusType + "\n";
        String returnValue = returnAddress + returnPortNumber + returnConnectionType + returnStartTime + returnEndTime + returnStatusType;
        return returnValue;
    }
}
