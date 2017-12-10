package com.gordeev.io;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {

    private InputStream inputStream;
    private byte[] buffer = new byte[128];
    private int index;
    private int count;

    BufferedInputStream(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        if (index == count){
            count = inputStream.read(buffer);
            index = 0;
            if (count == -1) {
                return -1;
            }
        }
        return buffer[index++];
    }
}
