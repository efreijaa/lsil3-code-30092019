/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JAA
 */
public class PersonneIHM implements ActionListener {

    JFrame frame = new JFrame();
    JButton button = new JButton("Clic");

    public void init() {
        button.addActionListener(this);

        JLabel label = new JLabel("un petit texte");

        JPanel pane = new JPanel();
        pane.add(button);
        pane.add(label);

        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Hey! Ca marche! Vive les événements Swing!");
    }

}
