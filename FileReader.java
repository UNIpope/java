package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {
    String fileName;
    File file;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public void openFile() {
        this.file = new File(this.fileName);
    }

    public ArrayList readAll() {
        //var
        String word;
        ArrayList doc = new ArrayList();

        //scanner and array
        try {
            Scanner myScanner = new Scanner(this.file);

            while(myScanner.hasNext()) {
                word = myScanner.next();

                //remove esc chars
                word = word.replaceAll("\\.", "");
                word = word.replaceAll(":", "");
                word = word.replaceAll("=", "");
                word = word.replaceAll("-", "");
                word = word.replaceAll(",", "");
                word = word.replaceAll("\\ ", "");
                word = word.replaceAll("'s", "");
                word = word.replaceAll("\\?", "");
                word = word.replaceAll("\\!", "");
                word = word.replaceAll("\\(", "");
                word = word.replaceAll("\\)", "");
                word = word.replaceAll("\t", "");
                word = word.replaceAll("\n", "");

                word = word.toLowerCase();

                if(word != "" && word != "\n" && word != " "){
                    doc.add(word);
                }
            }

            myScanner.close();
        } catch (FileNotFoundException var3) {
            System.out.println(var3.getMessage());
        }

        return doc;
    }
}
