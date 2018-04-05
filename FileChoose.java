/*package com.assignment;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class FileChoose {
    //https://www.mkyong.com/swing/java-swing-jfilechooser-example/

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
*/