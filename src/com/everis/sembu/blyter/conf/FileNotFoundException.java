package com.everis.sembu.blyter.conf;

import java.nio.file.FileSystemNotFoundException;

public class FileNotFoundException extends FileSystemNotFoundException {

    public FileNotFoundException(){
        System.err.println("Check in the configuration that the type specified for this parameter equals 'File'");
    }
}
