//code from https://www.programcreek.com/2013/03/java-sort-map-by-value/
// this code is called when sorting a map

package com.assignment;

import java.util.Comparator;
import java.util.HashMap;

class ValueComparator implements Comparator<String> {

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ValueComparator(HashMap<String, Integer> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if(map.get(s1) >= map.get(s2)){
            return -1;
        }else{
            return 1;
        }
    }
}
//end of ref
