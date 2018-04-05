package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {
    String fileName;
    String stopName = "stop.txt";
    File fleExample;
    File stopFile;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public void openFile() {
        this.fleExample = new File(this.fileName);
        this.stopFile = new File(this.stopName);
    }

    public String readLine() {
        String line = "no line in file";

        try {
            Scanner myScanner = new Scanner(this.fleExample);
            if (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
            }

            myScanner.close();
        } catch (FileNotFoundException var3) {
            System.out.println(var3.getMessage());
        }

        return line;
    }

    public String readWord() {
        String word = "no word in file";

        try {
            Scanner myScanner = new Scanner(this.fleExample);
            if (myScanner.hasNext()) {
                word = myScanner.next();
            }

            myScanner.close();
        } catch (FileNotFoundException var3) {
            System.out.println(var3.getMessage());

        }

        return word;
    }

    public ArrayList readAll() {
        //var
        String word;
        ArrayList stop = new ArrayList();
        ArrayList doc = new ArrayList();

        //scanner and array
        try {
            Scanner myScanner = new Scanner(this.fleExample);
            Scanner stopWords = new Scanner(stopFile);

            while(stopWords.hasNext()){
                word = stopWords.next();
                stop.add(word);
            }


            while(myScanner.hasNext()) {
                word = myScanner.next();

                word = word.replaceAll("\\.", "");
                word = word.replaceAll(":", "");
                word = word.replaceAll(",", "");
                word = word.replaceAll(" ", "");
                word = word.replaceAll("'s", "");

                if(word != null && word != "\n" && word != " "){
                    doc.add(word);
                }
            }

            myScanner.close();
            stopWords.close();
        } catch (FileNotFoundException var3) {
            System.out.println(var3.getMessage());
        }

        return doc;
    }
}
