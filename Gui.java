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
import java.util.Arrays;
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
        choose = new JButton(" Open first file ");
        add(choose);
        choose.addActionListener(this);

        choose2 = new JButton("Open second file");
        add(choose2);
        choose2.addActionListener(this);

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

        if (e.getSource() == choose)
        {
            strdata = Gui.fileGui();
        }
        else if (e.getSource() == choose2)
        {
            strdata2 = Gui.fileGui();
        }
        else if (e.getSource() == b1){
            System.out.println("before");
            if((strdata.isEmpty())  || (strdata2.isEmpty())) {
                String cmp = cmp(strdata, strdata2);
                Gui.infoBox(cmp, "Topics:");
            }
            else{
                Gui.infoBox("select two files","Error");
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
        System.out.println(strdta.toString() );
        return strdta;
    }

    public String cmp(ArrayList s1, ArrayList s2){
        ArrayList<String> ar = new ArrayList<String>();;
        String commonWD = "Please select files.";

        if (s1.isEmpty() || s2.isEmpty()){
            commonWD = "please select 2 files";
            System.out.println("tits");
        }
        else {
            for (int i = 0; i < s1.size() - 1; i++) {
                System.out.println("how bout ashjbfdas");

                if (!Arrays.asList(s1).contains(s2.get(i))){
                    ar.add(s2.get(i).toString());
                    System.out.println(s2.get(i) + " gagyayagagagyaga");
                }

            }
        }

        //check if ! emty write array to a str
        if(!ar.isEmpty()) {
            System.out.println(ar);
            commonWD = ar.toString();
        }

        System.out.println(commonWD);

        return commonWD;
    }

}//end gui