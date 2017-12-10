package com.gordeev.io;

import java.io.IOException;
import java.io.Writer;

public class BufferedWriter extends Writer{
    private Writer writer;
    private char[] buffer = new char[128];
    private int index;

    BufferedWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void write(int c) throws IOException {
        if (c != -1){
            if (index == buffer.length){
                writer.write(buffer);
                index = 0;
            }
            buffer[index++] = (char) c;
        } else {
            writer.write(buffer);
        }
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
