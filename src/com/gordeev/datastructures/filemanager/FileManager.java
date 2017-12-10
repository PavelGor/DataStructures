package com.gordeev.datastructures.filemanager;

import java.io.*;

public class FileManager {

    public static int calculateFiles(String pathString) throws IOException {
        File file = new File(pathString);
        int count = 0;
        File[] tmp = file.listFiles();
        if (tmp == null) {return -1;}
        for (File innerFileName : tmp) {
            if (innerFileName.isDirectory()) {
                count += calculateFiles(innerFileName.getAbsolutePath());
            } else {
                count++;
            }
        }
        return count;
    }

    public static int calculateDirs(String pathString) throws IOException {
        File file = new File(pathString);
        int count = 0;
        for (File innerFileName : file.listFiles()) {
            if (innerFileName.isDirectory()) {
                count++;
                count += calculateDirs(innerFileName.getAbsolutePath());
            }
        }
        return count;
    }

    public boolean copy(String from, String to) throws IOException {
        File fileFrom = new File(from);
        File fileTo = new File(to);
        copy(fileFrom,fileTo);

        return true;
    }

    private void copy(File fileFrom, File fileTo) throws IOException {
        if (fileFrom.isFile()) {
            String newPath = fileTo.getAbsolutePath() + File.separator + fileFrom.getName();
            File tmpFile = new File(newPath);
            tmpFile.createNewFile();
            try (FileOutputStream fileOutputStream = new FileOutputStream(tmpFile);
                 FileInputStream fileInputStream = new FileInputStream(fileFrom)) {
                byte[] buffer = new byte[100];
                int n;
                while ((n = fileInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, n);
                }
            }
        } else {
            for (File innerFile : fileFrom.listFiles()) {
                if (innerFile.isDirectory()) {
                    String newPath = fileTo.getAbsolutePath() + File.separator + innerFile.getName();
                    File tmpDir = new File(newPath);
                    tmpDir.mkdir();
                    copy(innerFile, tmpDir);
                } else {
                    copy(innerFile, fileTo);
                }
            }
        }
    }

    public boolean move(String from, String to) throws IOException {
        return copy(from, to) && deleteAll(from);
    }

    private boolean deleteAll(String PathToDelete) throws NullPointerException {
        File file = new File(PathToDelete);

        if (file.isDirectory()) {
            for (File innerFile : file.listFiles()) {
                if (innerFile.isDirectory()) {
                    deleteAll(innerFile.getAbsolutePath());
                    innerFile.delete();
                } else {
                    innerFile.delete();
                }
            }
        } else {
            boolean del = file.delete();
        }

        return true;

    }

}
