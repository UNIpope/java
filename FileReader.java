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

    public ArrayList readAll() {
        //var
        String word;
        ArrayList doc = new ArrayList();

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

        //scanner and array
        try {
            Scanner myScanner = new Scanner(this.fleExample);

            while(myScanner.hasNext()) {
                word = myScanner.next();

                //remove esc chars
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
        } catch (FileNotFoundException var3) {
            System.out.println(var3.getMessage());
        }

        return doc;
    }
}
