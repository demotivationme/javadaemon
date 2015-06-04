package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by demo on 25.05.15.
 */
public class Config {
    private ArrayList<ConfigItem> config = new ArrayList<>();

    public ArrayList<ConfigItem> getConfig() {
        return config;
    }

    public void setConfig(ArrayList<ConfigItem> config) {
        this.config = config;
    }
    public String readFile(String filename)
    {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
