package com.gordeev.io;

import org.junit.Test;

import java.io.*;

public class ioTest {

    @Test
    public void testBufferedInputOutputStream() throws IOException {
        try (InputStream inputStream = new BufferedInputStream(
                                        new FileInputStream("logFile.txt"));
             OutputStream outputStream = new BufferedOutputStream(
                                          new FileOutputStream("newLogFile.txt"))){
            int value;
            while ((value = inputStream.read()) != -1) {
                outputStream.write(value);
                //System.out.print((char) value);
            }
        }
    }

    @Test
    public void testInputOutputStreamReaderWriter () throws IOException {
        try (Reader reader = new InputStreamReader(
                                new FileInputStream("logFile.txt"));
             Writer writer = new OutputStreamWriter(
                                new FileOutputStream("newLogFile.txt"))){

            char[] buffer = new char[128];
            int count;
            while ((count = reader.read(buffer)) != -1){
                writer.write(buffer);
                //System.out.print(new String(buffer));
            }
        }
    }

    @Test
    public void testReaderWriter() throws IOException {
        try (Reader reader = new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream("logFile.txt")));
             Writer writer = new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream("newLogFile.txt")))){

            int c;
            while ((c = reader.read()) != -1){
                writer.write(c);
                //System.out.print((char) c);
            }
        }
    }
}
