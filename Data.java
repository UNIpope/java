/*
author: jack duggan
compiler: intellej
OS: win 10

desc: this is where any calculations are done
 */
package com.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Data {
    //variables
    ArrayList<String> arrayList;
    String file;


    //con
    public Data(String file) {
        //var
        this.file = file;
        int total;
        String word = " ";
        Map<String, Integer> amount = new HashMap<String, Integer>();
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
                "your", "yours", "yourself", "yourselves"
        };

        //open chosen file
        fileReader.openFile();
        arrayList = fileReader.readAll();

        //remove stop words
        for (int a = 0; a < stop_words.length; a++) {

            if (arrayList.contains( stop_words[a])) {
                arrayList.remove(stop_words[a]);
            }

        }//end 4

        //total num of words
        total = arrayList.size();

        for(int i = 0; (i <= (arrayList.size() - 1)) ; i++){

            word = arrayList.get(i);
            System.out.println(word);

            if(amount.containsKey(word)){
                amount.put(word,(amount.get(word)+1));
            }
            else{
                amount.put(word,1);
            }//end if

        }//end 4
        System.out.println(amount);

        /*
        //test print all
        System.out.println(arrayList);
        System.out.println(total);
        for(int i = 0; i < stop_words.length; i ++) {
            System.out.println(stop_words[i]);
        }

        */

    }


    //methods
    public String toString() {
        //return "Data{" + "arrayList=" + arrayList + "\nfile='" + file + '\'' + "\nmap='" + data + '}';
        return "the top words: ";
    }
}//end data
