package com.gordeev.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class OutputStreamWriter extends Writer {

    private OutputStream outputStream;

    OutputStreamWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(char[] charBuffer) throws IOException {
        byte[] byteBuffer = new byte[charBuffer.length];

        for (int i = 0; i < charBuffer.length; i++) {
            byteBuffer[i] = (byte) charBuffer[i];
        }
        outputStream.write(byteBuffer);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
