package com.everis.sembu.blyter;


import com.everis.sembu.util.ods;
import com.everis.sembu.util.Transformer;

import java.io.File;

public class Configuration {

    protected String ods = null,
                     src = null,
                     xsl = null,
                     out = null,
                     outDir = null;

    protected String key = null,
                     val = null;

    protected void printUsage(){

        String top = "Class Configuration(String argList[]) -> the list of expected arguments is composed of ";
        top += "the following elements:\n";
        top += "-ods:filePath.ods, Open Document Spreadsheet containing the configuration definition, or;\n";
        top += "-src:filePath.xml, XML instance containing the definition, e.g. the content.xml file extracted from an ODS file;\n";
        top += "-xsl:GenericodeConfigurationTemplateFile.xsl | JSONConfigurationTemplateFile.xsl, Stylesheet for the transformation of the ods or the xml source file into a GC or JSON file;\n";
        top += "-out:filePath.gc | filePathName.json, Genericode or Json file name produced as a result of the transformation;\n";
        top += "-outDir:directoryPath, Directory where the output file is to be saved.";

    }
    public Configuration(String argList[]){

        if(argList.length < 4) printUsage();

        for(String a: argList){

            try {
                String[] al = a.split(":");
                key = al[0];
                val = al[1];
            }catch (Exception e){
                System.err.println("Invalid argument " + a);
            }

            switch (key) {
                case "-ods": ods = val; break;
                case "-src": src = val; break;
                case "-xsl": xsl = val; break;
                case "-out": out = val; break;
                case "-outDir": outDir = val; break;
                default: printUsage();
            }
        }
    }

    public void createConfigurationFile(){

        File f  = new File(out);

        if (ods != null && src == null) {
            ods c = new ods(ods, outDir);
            c.getContent();
            src = outDir + "/" + "content.xml";
        } else if (ods == null && src != null){
            src = outDir + "/" + src;
        } else {
            printUsage();
            return;
        }

        String o = outDir + "/" + out;

       Transformer t = new Transformer();
       t.transform();

    }

    public void loadConfigurationFile(){

    }

}
