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

    protected String src = null,
                     xsl = null,
                     out = null,
                     outDir = null;

    protected String key = null,
                     val = null;

    public Configuration(String argList[]){

        for(String a: argList){

            try {
                String[] al = a.split(":");
                key = al[0];
                val = al[1];
            }catch (Exception e){
                System.err.println("Invalid argument " + a);
            }

            switch (key) {
                case "-src":
                    src = val;
                    break;
                case "-xsl":
                    xsl = val;
                    break;
                case "-out":
                    out = val;
                    break;
                case "-outDir":
                    outDir = val;
                    break;
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

}
