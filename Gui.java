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
import java.util.ArrayList;
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
    JButton choose2;
    JButton b1;
    ArrayList strdata = null;
    ArrayList strdata2 = null;

    //con
    Gui (String title) {
        super(title);
        //set size, loc and layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//stops process
        setSize(320, 100);
        setLocationRelativeTo(null);//middle of screen
        setResizable(false);
        setLayout(new FlowLayout());

        //file chooser buttons
        choose = new JButton(" Open first file   ");
        add(choose);
        choose.addActionListener(this);

        choose2 = new JButton("Open second file");
        add(choose2);
        choose2.addActionListener(this);

        //button to show top words
        b1 = new JButton("          Get top words in both files             ");
        add(b1);
        b1.addActionListener(this);

        //make these appear
        setVisible(true);

    }

    //action listener
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == choose)
        {
            strdata = Gui.fileGui();
        }
        else if (e.getSource() == choose2)
        {
            strdata2 = Gui.fileGui();
        }
        else if (e.getSource() == b1)
        {
            if ((strdata != null)||(strdata2 != null)){

                DataHandler list = new DataHandler(strdata, strdata2);
                Gui.infoBox(list.toString(), "Top words in common:");
            }
            else{
                Gui.infoBox("select both files please!", "Top words in common:");
            }
        }//end if

    }//end act listen


    //info box pop up
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    //open file chooser returns an array of the top 10 words
    public static ArrayList fileGui(){
        //var
        ArrayList strdta = new ArrayList();
        //file picker https://www.mkyong.com/swing/java-swing-jfilechooser-example/ ref:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        jfc.setDialogTitle("Select a text file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Select a text file please", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);

        //end of ref

        if (returnValue == JFileChooser.APPROVE_OPTION){
            System.out.println(jfc.getSelectedFile().getPath());
            String read_in = jfc.getSelectedFile().getPath();

            //call data class
            Data new_data = new Data(read_in);

            //pop up for top words
            new_data.print();

            //read in data
            strdta = new_data.returnArray();

        }
        else{
            Gui.infoBox("Pick a file please","error");
        }//end if

        //print out Array of data
        System.out.println(strdta.toString()+"end of file");
        return strdta;
    }


}//end gui