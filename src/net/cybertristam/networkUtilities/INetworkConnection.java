/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 14, 2005
 * PROGRAM/FILENAME: PACKAGE_NAME.net.cybertristam.networkUtilities.INetworkConnection
 * EXPLANATION: This is an interface that will allow a Strategy Pattern to be developed to
 *  support the Network Connection Diagnostics Tool.
 * TEST DATA & EXPECTED RESULTS: N/A
 * ENTRY: N/A
 * EXPECTED RESULTS: N/A
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 * 1           Mar 14, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */

package net.cybertristam.networkUtilities;

import net.cybertristam.dataObjects.ConnectionStatus;


public interface INetworkConnection {
    public abstract String getAddress(String address);
    public abstract void setAddress(String address);
    public abstract Integer getPortNumber();
    public abstract void setPortNumber(Integer portNumber);
    public abstract Integer getTimeout();
    public abstract void setTimeout(Integer timeout);
    public abstract void makeConnection();
}
