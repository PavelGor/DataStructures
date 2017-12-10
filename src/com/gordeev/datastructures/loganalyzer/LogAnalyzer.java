package com.gordeev.datastructures.loganalyzer;

import com.gordeev.datastructures.list.ArrayList;
import com.gordeev.datastructures.list.List;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class LogAnalyzer {

    public List logAnalyzer(String path, Date timeFrom, Date timeTo) throws IOException, ParseException {
        BufferedReader bufReader = new BufferedReader(new FileReader(path));
        String line;
        DateFormat format = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
        List logList = new ArrayList();

        while ((line = bufReader.readLine()) != null) {
            int startIndex = line.indexOf("[");
            //int endIndex = line.indexOf("]");
            String lineTime = line.substring(startIndex+1,startIndex+21);
            Date dateLine = format.parse(lineTime);
            if (dateLine.after(timeFrom) && dateLine.before(timeTo)){
                LogToken record = new LogToken();
                record.time = dateLine;
                if (line.indexOf("GET") > 0){
                    record.message = line.substring(line.indexOf("GET")+4);
                    record.method = HttpMethod.GET;
                } else {
                    record.message = line.substring(line.indexOf("POST")+5);
                    record.method = HttpMethod.POST;
                }
                logList.add(record);
            }

        }

        return logList;

    }

}
