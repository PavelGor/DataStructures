package com.gordeev.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class InputStreamReader extends Reader {

    private InputStream inputStream;

    InputStreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read(char[] buffer) throws IOException {
        byte[] byteBuffer = new byte[buffer.length];
        int count = inputStream.read(byteBuffer);

        for (int i = 0; i < count; i++) {
            buffer[i] = (char) byteBuffer[i];
        }
        return count;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
