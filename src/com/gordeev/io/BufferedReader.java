package com.gordeev.io;

import java.io.IOException;
import java.io.Reader;

public class BufferedReader extends Reader{

    private Reader reader;
    private char[] buffer = new char[128];
    private int index;
    private int count;

    BufferedReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public int read() throws IOException {
        if (index == count){
            count = reader.read(buffer);
            index = 0;
            if (count == -1) {
                return -1;
            }
        }
        return (int) buffer[index++];
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
