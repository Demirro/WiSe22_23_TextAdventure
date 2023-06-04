package de.uk.java.utils;


import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public static ArrayList<String> readName(String species) {
        ArrayList<String> names = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File("enemyNames.json")))){
            JSONTokener jt = new JSONTokener(br);
            JSONObject jobj = new JSONObject(jt);
            JSONArray array = jobj.getJSONArray("enemyNames");

            for (int i = 0; i < array.length(); i++) {
                JSONArray nameArray = array.getJSONObject(i).getJSONArray(species);
                for (int j = 0; j < nameArray.length(); j++) {
                    names.add(nameArray.getString(i));
                }
                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return names;
    }
}
