package com.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class DataHandler {
    //var
    String cmp;

    //con
    public DataHandler (ArrayList strdata, ArrayList strdata2){
        if((!strdata.isEmpty())  || (!strdata2.isEmpty())) {
            cmp = cmp(strdata, strdata2);
        }
        else{
            cmp = "select to files";
        }
    }//end con

    //meth
    public String cmp(ArrayList s1, ArrayList s2){
        ArrayList<String> ar = new ArrayList<String>();;
        String commonWD = "the top common words are:\n";

        if (s1 == null || s2 == null){
            commonWD = "please select 2 files";
        }
        else {
            for (int i = 0; (i < s1.size() - 1) && (i < 5); i++) {
                if (!Arrays.asList(s1).contains(s2.get(i))){ //if s1 !contain s2
                    ar.add(s2.get(i).toString());
                }//end if
            }//end 4
        }//end if

        //check if ! empty write array to a str
        if(!ar.isEmpty()) {
            for(int i = 0; i < ar.size() - 1; i++){
                commonWD = commonWD + ar.get(i) + ", ";
                System.out.println(ar.get(i));
            }
            commonWD = commonWD + ar.get(ar.size() - 1) +".";
        }

        System.out.println(commonWD);

        return commonWD;
    }//end cmp

    @Override
    public String toString() {
        return cmp;
    }//end tostr
}//end datahand
