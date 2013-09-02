/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 18, 2005
 * PROGRAM/FILENAME: net.cybertristam.networkUtilities.NetworkSocket
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

import java.net.SocketAddress;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.IOException;

public class NetworkSocket extends Throwable {
    private Object networkSocketManager;
    private SocketAddress socketAddress;

    public NetworkSocket(){
    }

    public NetworkSocket(DatagramSocket networkSocketManager){
        new NetworkSocket(networkSocketManager,new InetSocketAddress("localhost",7));
    }

    public NetworkSocket(Socket networkSocketManager){
        new NetworkSocket(networkSocketManager,new InetSocketAddress("localhost",7));
    }

    public NetworkSocket(DatagramSocket networkSocketManager, SocketAddress socketAddress){
        setNetworkSocketManager(networkSocketManager);
        setSocketAddress(socketAddress);
    }

    public NetworkSocket(Socket networkSocketManager, SocketAddress socketAddress){
        setNetworkSocketManager(networkSocketManager);
        setSocketAddress(socketAddress);
    }

    public Object getNetworkSocketManager() {
        return networkSocketManager;
    }

    public void setNetworkSocketManager(Object networkSocketManager) {
        this.networkSocketManager = networkSocketManager;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public void makeConnection(SocketAddress socketAddress, int timeout) {
        if (networkSocketManager instanceof Socket) {
            Socket socket = (Socket) networkSocketManager;
            try {
                socket.connect(socketAddress, timeout);
                socket.close();
            }
            catch (Exception ex) {
            }
        }
        if (networkSocketManager instanceof DatagramSocket) {
            DatagramSocket socket = (DatagramSocket) networkSocketManager;
            try {
                socket.setSoTimeout(timeout);
                socket.connect(socketAddress);
                socket.close();
            }
            catch (Exception ex) {
            }
        }
    }

}
