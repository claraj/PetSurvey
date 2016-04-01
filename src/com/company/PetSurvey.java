package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by we4954cp on 3/31/2016.
 */
public class PetSurvey extends JFrame{
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JPanel rootPanel;
    private JButton submitButton;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    boolean hasFish;
    boolean hasCats;
    boolean hasDogs;


    PetSurvey() {
        super("Pet survey application"); // Set window title
        setContentPane(rootPanel);    //This window contains rootPanel
        setPreferredSize(new Dimension(400, 400));

        pack();    //Add components and size window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop program when window closed


        setVisible(true); //show window, once all is set up.
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hasDogs = dogCheckBox.isSelected();
            }
        });

        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hasCats = catCheckBox.isSelected();
            }
        });


        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hasFish = fishCheckBox.isSelected();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dog = (hasDogs) ? "a dog " : "no dogs";    //The most concise way

                String cat = (catCheckBox.isSelected()) ? "a cat" : "no cats";  //Slightly more verbose

                String fish;                //The most verbose
                if (hasFish == true) {
                    fish = "a fish";
                } else {
                    fish = "no fish";
                }


                surveyResultsLabel.setText("user has " + dog + " and " + cat + " and " + fish);

            }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?", "Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

}
