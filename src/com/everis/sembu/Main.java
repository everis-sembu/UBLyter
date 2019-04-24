package com.everis.sembu;

import com.everis.sembu.blyter.Configuration;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {



    public static void createConfFile(){

        String[] argList = {"-src:./conf/blyter.conf.ods", "-xsl:./conf/blyter.conf.gc.xsl", "-out:blyter.conf.gc", "-outDir:./conf"};
        Configuration c = new Configuration(argList);

        c.createConfigurationFile();

    }

    public static void createJSONObject(){
        //confElement c = new confElement();

        try {
            Map<String, String> map = new HashMap<>();
            map.put("key", "value");
            ObjectMapper mapper = new ObjectMapper();
            String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
            System.out.println(jsonResult);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }

    public static void gsonLesson1(){

    }
    public static void main(String[] args) {

        // createConfFile();

        //createJSONObject();

        gsonLesson1();

    }
}
