package com.gordeev.datastructures.filemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileManagerTest {
    private String fromDir = "TmpDirFrom";
    private String toDir = "TmpDirTo";
    private FileManager fileManager = new FileManager();

    @Before
    public void before() throws IOException {
        String dirOne = fromDir + "\\Dir1";
        String dirTwo = fromDir + "\\Dir2";
        String innerDir = dirOne + "\\Dir12";
        new File(fromDir).mkdir();
        new File(toDir).mkdir();
        new File(dirOne).mkdir();
        new File(dirTwo).mkdir();
        new File(innerDir).mkdir();

        for (int i = 0; i < 5; i++) {
            new File(dirOne + "\\" + i + ".txt").createNewFile();
        }
        for (int i = 0; i < 5; i++) {
            new File(innerDir + "\\"+i*10 + ".txt").createNewFile();
        }
    }

    @Test
    public void testCalculateFiles() throws IOException {
        assertEquals(10,FileManager.calculateFiles(fromDir));
    }

    @Test
    public void testCalculateDirs() throws IOException {
        assertEquals(3,FileManager.calculateDirs(fromDir));
    }

    @Test
    public void testCopyDir() throws IOException {
        fileManager.copy(fromDir,toDir);
        assertEquals(3,FileManager.calculateDirs(toDir));
        assertEquals(10,FileManager.calculateFiles(toDir));
    }

    @Test
    public void testCopyFile() throws IOException {
        fileManager.copy("TmpDirFrom\\Dir1\\1.txt","TmpDirFrom\\Dir2");
        assertEquals(1,FileManager.calculateFiles("TmpDirFrom\\Dir2"));
    }

    @Test
    public void testMove() throws IOException {
        fileManager.move(fromDir,toDir);
        assertEquals(0,FileManager.calculateFiles(fromDir));
        assertEquals(0,FileManager.calculateDirs(fromDir));
        assertEquals(3,FileManager.calculateDirs(toDir));
        assertEquals(10,FileManager.calculateFiles(toDir));
    }

    @Test
    public void testMoveFile() throws IOException {
        fileManager.move("TmpDirFrom\\Dir1\\1.txt","TmpDirFrom\\Dir2");
        assertEquals(9,FileManager.calculateFiles("TmpDirFrom\\Dir1"));
        assertEquals(1,FileManager.calculateFiles("TmpDirFrom\\Dir2"));
    }

    @Test
    public void testDel() throws IOException {
        assertEquals(3,FileManager.calculateDirs(fromDir));
        deleteAll(fromDir);
        assertEquals(0,FileManager.calculateDirs(fromDir));
    }

    @After
    public void after(){
        deleteAll(fromDir);
        deleteAll(toDir);
        new File(fromDir).delete();
        new File(toDir).delete();
    }

    private void deleteAll(String PathToDelete){
        File file = new File(PathToDelete);
        for (File innerFile : file.listFiles()){
            if (innerFile.isDirectory()){
                deleteAll(innerFile.toString());
                innerFile.delete();
            } else {
                innerFile.delete();
            }
        }
    }

}
