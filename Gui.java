package com.assignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class Gui extends JFrame implements ActionListener
{
    //var
    JButton choose;
    JButton b1;
    JLabel l1;

    //con
    Gui (String title) {
        super(title);
        //set size and layout
        setSize(800, 600);
        setLayout(new FlowLayout());

        //file chooser
        choose = new JButton("Open file");
        add(choose);
        choose.addActionListener(this);

        //button
        b1 = new JButton("Enter");
        add(b1);
        b1.addActionListener(this);

        //lable
        l1 = new JLabel("");
        add(l1);


        //make these appear
        setVisible(true);

    }





    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == choose)
        {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select a text file");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
            jfc.addChoosableFileFilter(filter);

            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                System.out.println(jfc.getSelectedFile().getPath());
            }

        }
        else if (e.getSource() == b1){
            Gui.infoBox("awnsers boi","Topics:");
        }


    }

}



