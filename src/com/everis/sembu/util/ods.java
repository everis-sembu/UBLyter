package com.everis.sembu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ods {

    String inZip, outDir;

    public ods(String inputZipFilePathName, String outputDir){
        inZip = inputZipFilePathName;
        outDir = outputDir;
    }

    public void getContent() {

        //create output directory is not exists

        File dir = new File(outDir);
        if(!dir.exists()) dir.mkdirs();


        byte[] buffer = new byte[1024];
        FileInputStream fis;

        try {

            fis = new FileInputStream(inZip);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                if(fileName.equalsIgnoreCase("content.xml")){
                    File odsContent = new File(outDir + "/content.xml");
                    System.out.println("unzipping to: " + odsContent.getAbsolutePath());
                    FileOutputStream fos = new FileOutputStream(odsContent);
                    int len;
                    while((len = zis.read(buffer)) > 0){
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
