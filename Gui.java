/*
author: jack duggan
compiler: intellej
OS: win 10

desc: this is the gui class
 */

package com.assignment;

//main gui
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;

//file opener
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class Gui extends JFrame implements ActionListener
{
    //var
    JButton choose;
    JButton b1;
    JLabel l1;
    String out = "No data: please open file first";

    //con
    Gui (String title) {
        super(title);
        //set size, loc and layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//stops process
        setSize(270, 80);
        setLocationRelativeTo(null);//middle of screen
        setResizable(false);
        setLayout(new FlowLayout());

        //file chooser button
        choose = new JButton("Open file");
        add(choose);
        choose.addActionListener(this);

        //button to show top words
        b1 = new JButton("Enter");
        add(b1);
        b1.addActionListener(this);

        //make these appear
        setVisible(true);

    }

    //action listener
    public void actionPerformed(ActionEvent e)
    {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        if (e.getSource() == choose)
        {
            //file picker https://www.mkyong.com/swing/java-swing-jfilechooser-example/
            jfc.setDialogTitle("Select a text file");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
            jfc.addChoosableFileFilter(filter);
            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION){
                System.out.println(jfc.getSelectedFile().getPath());
                String read_in = jfc.getSelectedFile().getPath();

                //call data class
                Data new_data = new Data(read_in);
                System.out.println(new_data);
                //read in data
                out = new_data.toString();
            }
            else{
                Gui.infoBox("Pick a file please","error");
            }//end if
        }
        else if (e.getSource() == b1){
            Gui.infoBox(out,"Topics:");
        }//end if
    }//end act listen

    //info box pop up
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}//end gui