package com.gordeev.io;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {

    private OutputStream outputStream;
    private byte[] buffer = new byte[8];
    private int index;

    BufferedOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int value) throws IOException {
        if (value < 0 || value > 255){
            throw new IllegalArgumentException();
        }
            if (index == buffer.length) {
                outputStream.write(buffer);
                index = 0;
            }
        buffer[index++] = (byte) value;

    }
}
