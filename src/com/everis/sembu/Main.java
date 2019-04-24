package com.everis.sembu;

import com.everis.sembu.blyter.Configuration;



public class Main {



    public static void createConfFile(){

        String[] argList = {"-src:./conf/blyter.conf.ods", "-xsl:./conf/blyter.conf.gc.xsl", "-out:blyter.conf.gc", "-outDir:./conf"};
        Configuration c = new Configuration(argList);

        c.createConfigurationFile();

    }


    public static void gsonLesson1(){

    }
    public static void main(String[] args) {

        // createConfFile();

        //createJSONObject();

        gsonLesson1();

    }
}
