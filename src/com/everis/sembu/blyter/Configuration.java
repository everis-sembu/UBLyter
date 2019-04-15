package com.everis.sembu.blyter;


import com.everis.sembu.util.ods;

import net.sf.saxon.Transform;
import net.sf.saxon.TransformerFactoryImpl;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Configuration {

    protected String ods = null,
                     src = null,
                     xsl = null,
                     out = null,
                     outDir = null;

    protected String key = null,
                     val = null;

    protecte void printUsage(){
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
        ods c = new ods(src, outDir);
        c.getContent();

        String s = outDir + "/" + "content.xml";
        String o = outDir + "/" + out;

        try {
            File inputXml = new File(s);
            File xsltFile = new File(xsl);

            Source xmlSource  = new StreamSource(inputXml);
            Source xsltSource = new StreamSource(xsltFile);
            StringWriter sw   = new StringWriter();
            Result result     = new StreamResult(sw);

            TransformerFactory transFact = new TransformerFactoryImpl();
            Transformer trans = transFact.newTransformer(xsltSource);

            trans.transform(xmlSource, result);
            File file = new File(o);
            new File(file.getParent()).mkdir();
            FileWriter output = new FileWriter(file);
            output.write(sw.toString());
            output.close();

        }catch (TransformerException | IOException e){
            e.printStackTrace();
        }
    }

    public void loadConfigurationFile(){

    }

}
