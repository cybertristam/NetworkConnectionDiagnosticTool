/**
 * AUTHOR: jewright
 * DATE/TIME:  Mar 22, 2005
 * PROGRAM/FILENAME: net.cybertristam.controller.NetworkConnectionController
 * EXPLANATION: This is the controller for the network connection application.
 * TEST DATA & EXPECTED RESULTS:
 * ENTRY:
 * EXPECTED RESULTS:
 * REVISION HISTORY:
 * VERSION NUMBER     DATE       AUTHOR
 *     1           Mar 22, 2005      jewright
 * REQUIREMENTS:
 * EDITOR/IDE: IntelliJ IDEA with VIM Keymap.
 */

package net.cybertristam.controller;

import java.util.Observable;
import java.util.Observer;

public class NetworkConnectionController extends Observable implements Observer {
    public final static Integer GUI = new Integer(0);
    public final static Integer CMD = new Integer(1);

    public void runCommand(){

    }

    public void setHMI(Integer guiType){
        if(guiType == GUI){
        }
        else if(guiType == CMD){
        }
        else{
            //Throw Error exception.
        }
    }

    public static void main(String[] args){
        NetworkConnectionController ncc = new NetworkConnectionController();
        if(args.length > 0) {
            if(args[0].toUpperCase() == "CMD"){
                ncc.setHMI(ncc.CMD);
            }
            else if(args[0].toUpperCase() == "gui"){
                ncc.setHMI(ncc.GUI);
            }
        }
        else {
            ncc.setHMI(ncc.GUI);
        }
    }

    public void update(Observable o, Object arg) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
