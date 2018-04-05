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
    String out;

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

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        if (e.getSource() == choose)
        {

            jfc.setDialogTitle("Select a text file");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
            jfc.addChoosableFileFilter(filter);

            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                System.out.println(jfc.getSelectedFile().getPath());
                String read_in = jfc.getSelectedFile().getPath();

                Data new_data = new Data(read_in);
                System.out.println(new_data);
                out = new_data.toString();
            }
            else{
                Gui.infoBox("Pick a file please","error");
            }



        }
        else if (e.getSource() == b1){

            Gui.infoBox(out,"Topics:");
        }



    }

}



