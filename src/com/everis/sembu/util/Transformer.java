package com.everis.sembu.util;

import net.sf.saxon.TransformerFactoryImpl;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Transformer {

    String src = null,
           xsl = null,
           out = null;
    TransformerFactory
            transFact = null;

    /*
        Constructors: If the default constructor is used the arguments for the
        transformation need to be provided using the setter methods.
        The use of the setter methods allows the reutilization of the same
        FactoryImpl without having to re-instantiate the class.
     */

    public Transformer(){

    }

    public Transformer(String srcFilePathName, String xslFilePathName, String outFilePathName){
        src = srcFilePathName;
        xsl = xslFilePathName;
        out = outFilePathName;
    }

    public void setSrc(String srcFilePathName){
        src = srcFilePathName;
    }
    public void setXSL(String xslFilePathName){
        xsl = xslFilePathName;
    }
    public void setOut(String outFilePathName){
        out = outFilePathName;
    }

    public void transform(){
        try {
            File inputXml = new File(src);
            File xsltFile = new File(xsl);

            // lazy implementation allows a more efficient reuse of the
            // class without having to reinstantiate the Factory each time;

            if (transFact != null)
                transFact = new TransformerFactoryImpl();

            Source xmlSource  = new StreamSource(inputXml);
            Source xsltSource = new StreamSource(xsltFile);
            StringWriter sw   = new StringWriter();
            Result result     = new StreamResult(sw);

            javax.xml.transform.Transformer trans = transFact.newTransformer(xsltSource);

            trans.transform(xmlSource, result);
            File file = new File(out);
            new File(file.getParent()).mkdir();
            FileWriter output = new FileWriter(file);
            output.write(sw.toString());
            output.close();

        }catch (TransformerException | IOException e){
            e.printStackTrace();
        }
    }
}
