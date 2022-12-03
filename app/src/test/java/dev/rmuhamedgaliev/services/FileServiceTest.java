package dev.rmuhamedgaliev.services;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    private final FileService fileService = new FileService();

    @Test
    public void testUnzipFolder() throws IOException {
        var file = new File(System.getProperty("java.io.tmpdir") + "/demo-zip");
        System.out.println(file.getAbsoluteFile());
        if (file.exists()) {
            file.delete();
        }
        file.mkdir();

        var testZipFile = new File("demo.zip");

        fileService.unzipFile(new FileInputStream(testZipFile), file);
    }

    @Test
    public void testUnzipFolderFromUrl() throws IOException {
        var file = new File(System.getProperty("java.io.tmpdir") + "/demo-zip");
        System.out.println(file.getAbsoluteFile());
        if (file.exists()) {
            file.delete();
        }
        file.mkdir();

        var testZipFile = new URL("https://github.com/rmuhamedgaliev/solvery-download-zip/blob/master/app/demo.zip?raw=true");

        fileService.unzipFile(testZipFile.openStream(), file);
    }

}