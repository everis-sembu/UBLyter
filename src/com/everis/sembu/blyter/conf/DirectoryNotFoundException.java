package com.everis.sembu.blyter.conf;

import java.nio.file.FileSystemNotFoundException;

public class DirectoryNotFoundException extends FileSystemNotFoundException {

    public DirectoryNotFoundException(){
        System.err.println("Check in the configuration that the type specified for this parameter equals 'Directory'");
    }
}
