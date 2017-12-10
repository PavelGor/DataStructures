package com.gordeev.datastructures.loganalyzer;

import com.gordeev.datastructures.list.List;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class LogAnalyzerTest {

    @Test
    public void testLogAnalyzer() throws IOException, ParseException {

        DateFormat format = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        List logList = logAnalyzer.logAnalyzer("logFile.txt", format.parse("07/Mar/2004:17:16:00"), format.parse("07/Mar/2004:17:50:44"));
        LogToken recordOne = (LogToken) logList.get(0);
        LogToken recordTwo = (LogToken) logList.get(1);
        assertEquals(HttpMethod.POST, recordOne.method);
        assertEquals(HttpMethod.GET,recordTwo.method);
        assertEquals(16,logList.size());


    }
}
