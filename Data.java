package com.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Data {
    //variables
    ArrayList arrayList;
    String file = "role.txt";
    Map<String, Integer> data = new HashMap<String, Integer>();

    //con
    public Data(String file) {
        this.file = file;
        int total;
        FileReader fileReader = new FileReader(file);
        fileReader.openFile();
        arrayList = fileReader.readAll();
        total = arrayList.size();
        System.out.println(arrayList);
        System.out.println(total);
        //for(int i = 0; i <=(arrayList.size()) ; i++){

          //  data.put(arrayList.get(i).toString(), data.getOrDefault(data.getValue(i) + 1, 0));
        //}

    }


    //meth

    public String toString() {
        return "Data{" + "arrayList=" + arrayList + "\nfile='" + file + '\'' + "\nmap='" + data +
        '}';
    }
}
