/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.ActionsDB;

/**
 *
 * @author JAA
 */
public class Start {

    // POint d'entrée de notre application
    public static void main(String[] args) {
        ActionsDB adb = new ActionsDB();
        adb.afficherProgrammeurs(adb.getProgrammeurs(adb.getResultSet()));
    }

}
