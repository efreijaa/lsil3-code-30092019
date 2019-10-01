/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Constantes;
import utils.Constantes;

/**
 *
 * @author nitsu
 */
public class ActionsDB {

    Connection conn;
    //Statement stmt;
    //ResultSet rs;

    ArrayList<ProgrammeurBean> listeProg;

    public ActionsDB() {
        try {
            conn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Statement getStatement() {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return stmt;

    }

    public ResultSet getResultSet() {
        ResultSet rs = null;
        Statement stmt = this.getStatement();

        try {
            rs = stmt.executeQuery(Constantes.REQ);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public ArrayList getProgrammeurs(ResultSet rs) {
        listeProg = new ArrayList<>();
        try {
            while (rs.next()) {
                ProgrammeurBean progBean = new ProgrammeurBean();
                progBean.setNom(rs.getString("NOM"));
                progBean.setPrenom(rs.getString("PRENOM"));
                progBean.setAnNaissance(rs.getString("ANNAISSANCE"));
                listeProg.add(progBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeProg;
    }

    public void afficherProgrammeurs(ArrayList<ProgrammeurBean> listeProg) {
        
        for (ProgrammeurBean programmeurBean : listeProg) {
            System.out.println("NOM  : " + programmeurBean.getNom());
            System.out.println("PRENOM  : " + programmeurBean.getPrenom());
            System.out.println("ANNEE DE NAISSANCE  : " + programmeurBean.getAnNaissance());
        }
    }

}
