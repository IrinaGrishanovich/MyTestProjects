package com.fourc.testframework.helper;


import java.io.*;

public class Parser {

    public enum Parsers{csv}

    public static String[] getDataFrom(Parsers parser) {
        String[] data = getDataFromCSV();
        return data;
    }

    public static String[] getDataFromCSV(){
        String[] userEmailInfo = new String[20];

        String csvFile = "userEmailInfo.csv";

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                userEmailInfo = line.split(cvsSplitBy);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  userEmailInfo;
    }

}
