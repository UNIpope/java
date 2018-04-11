/*
author: jack duggan
compiler: intellej
OS: win 10

desc: this is where any calculations are done
 */
package com.assignment;

import javax.swing.*;
import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;


public class Data {
    //variables
    ArrayList<String> arrayList;
    TreeMap<String, Integer> sortedMap;
    String file;
    int total;


    //con
    public Data(String file) {
        //var
        this.file = file;
        String word = " ";
        HashMap<String, Integer> amount = new HashMap<String, Integer>();//no dupes
        FileReader fileReader = new FileReader(file);

        //stop words
        String stop_words[] = {"a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be", "because", "been", "before",
                "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down",
                "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here",
                "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its",
                "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours",
                "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's",
                "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through",
                "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's",
                "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've",
                "your", "yours", "yourself", "yourselves",""
        };

        //open chosen file
        fileReader.openFile();
        arrayList = fileReader.readAll();

        //remove stop words
        //convert to object
        arrayList.removeAll(Arrays.asList(stop_words));

        //total num of words
        total = arrayList.size();

        //import into hash map and count each word
        for(int i = 0; (i <= (arrayList.size()-1)); i++){

            word = arrayList.get(i);

            if(amount.containsKey(word)){
                amount.put(word,(amount.get(word)+1));
            }
            else{
                amount.put(word,1);
            }//end if
        }//end 4

        //sort map
        sortedMap = sortMapByValue(amount);
    }


    //methods
    //shows up to top words
    public void print() {
        //to stop out of bounds exception:
        double val;
        double[] values = new double[4];
        String[] names = new String[4];

        if(sortedMap.size() >= 3) {
            Data.infoBox("The top 3 words in this file are:\n" + sortedMap.keySet().toArray()[0] + ", " + sortedMap.keySet().toArray()[1] + " and "
                    + sortedMap.keySet().toArray()[2],"Top words");

        }
        else if(sortedMap.size() == 2){
            Data.infoBox("The top 2 words in this file are:\n" + sortedMap.keySet().toArray()[0] + " and " + sortedMap.keySet().toArray()[1],
                         "Top words");

        }
        else if(sortedMap.size() == 1){
            Data.infoBox("The top word int this file is:\n" + sortedMap.keySet().toArray()[0], "Top words");

        }
        else{
            Data.infoBox("Nothing in file","No words");
        }

        //bar chart
        if(sortedMap.size() >= 3) {
            bar();
        }

    }

    //sort map
    //code from https://www.programcreek.com/2013/03/java-sort-map-by-value/ ref:
    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys.
        //The comparator is used to sort the TreeMap by keys.
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }
    //end of ref

    //bar call
    public void bar(){
        //var
        double[] values = new double[4];
        String[] names = new String[4];
        int val;

        //frame
        JFrame f = new JFrame();
        f.setSize(400, 300);

        //map to array
        val = (int)sortedMap.values().toArray()[0];
        values[0] = val;
        names[0] = sortedMap.keySet().toArray()[0].toString();

        val = (int)sortedMap.values().toArray()[1];
        values[1] = val;
        names[1] = sortedMap.keySet().toArray()[1].toString();

        val = (int)sortedMap.values().toArray()[2];
        values[2] = val;
        names[2] = sortedMap.keySet().toArray()[2].toString();

        values[3] = total;
        names[3] = "The rest";

        //pass array to chart pannel
        f.getContentPane().add(new ChartPanel(values, names, "The 3 top words vs the rest:"));
        f.setVisible(true);



    }

    //returns the sorted maps keys as array list
    public ArrayList returnArray(){
        ArrayList arr = new ArrayList();

        for(int i = 0; i < sortedMap.size(); i++ ) {
            arr.add(sortedMap.keySet().toArray()[i].toString());
        }

        return arr;
    }

    //info box pop up
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}//end data
