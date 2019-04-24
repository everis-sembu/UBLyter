package com.everis.sembu;

import com.everis.sembu.blyter.conf.Configuration;
import com.everis.sembu.blyter.conf.Distribution;
import com.everis.sembu.blyter.conf.Parameter;
import com.everis.sembu.blyter.conf.Parameters;
import com.google.gson.Gson;


public class Main {



    public static void createConfFile(){

    /*
        String[] argList = {"-src:./conf/blyter.conf.ods", "-xsl:./conf/blyter.conf.gc.xsl", "-out:blyter.conf.gc", "-outDir:./conf"};
        Configuration c = new Configuration(argList);

        c.createConfigurationFile();


     */

    }

    public static void main(String[] args) {

        // createConfFile();

        //createJSONObject();

        //CreateConf();
        getConf();

    }

    private static void getConf(){
        String json = "{\"distribution\":{\"title\":\"Blyter Configuration File\",\"description\":\"RPaM metadaata and configuration parameters for the generation of UBL XSD Schemas\",\"modelShortName\":\"RPaM\",\"modelLongName\":\"Representation Powers and Mandates\",\"modelVersion\":\"1.0\",\"canonicalURI\":\"urn:eu:digit:isa:names:specification:rpam\",\"canonicalVesionURI\":\"urn:eu:digit:isa:names:specification:rpam:1.0\",\"locationURI\":\"https://github.com/everis-rpam/RPaM-Ontology\",\"agencyLongName\":\"Interoperability Solutions for Public Administrations, programme\",\"agencyIdentifier\":\"ISA2\"},\"globalVar\":{\"ABIEextension\":{\"name\":\"ABIEextensions\",\"value\":\"yes\",\"type\":\"String\",\"symbol\":\"${ABIEextensions}\"},\"UBLprevVersion\":{\"name\":\"UBLprevVersion\",\"value\":\"2.2\",\"type\":\"String\",\"symbol\":\"${UBLprevVersion}\"},\"UBLversion\":{\"name\":\"UBLversion\",\"value\":\"2.3\",\"type\":\"String\",\"symbol\":\"${UBLversion}\"}},\"inputFiles\":{\"ABIEextension\":{\"name\":\"ABIEextensions\",\"value\":\"yes\",\"type\":\"String\",\"symbol\":\"${ABIEextensions}\"},\"UBLprevVersion\":{\"name\":\"UBLprevVersion\",\"value\":\"2.2\",\"type\":\"String\",\"symbol\":\"${UBLprevVersion}\"},\"UBLversion\":{\"name\":\"UBLversion\",\"value\":\"2.3\",\"type\":\"String\",\"symbol\":\"${UBLversion}\"}},\"outputDirs\":{\"ABIEextension\":{\"name\":\"ABIEextensions\",\"value\":\"yes\",\"type\":\"String\",\"symbol\":\"${ABIEextensions}\"},\"UBLprevVersion\":{\"name\":\"UBLprevVersion\",\"value\":\"2.2\",\"type\":\"String\",\"symbol\":\"${UBLprevVersion}\"},\"UBLversion\":{\"name\":\"UBLversion\",\"value\":\"2.3\",\"type\":\"String\",\"symbol\":\"${UBLversion}\"}}}";
        Configuration conf = new Gson().fromJson(json, Configuration.class);

        System.out.println(conf.inDir("ABIEextension"));
        System.out.println(conf.outDir("ABIEextension"));




    }

    private static void CreateConf() {

        Distribution dist = new Distribution();

        dist.setTitle("Blyter Configuration File");
        dist.setDescription("RPaM metadaata and configuration parameters for the generation of UBL XSD Schemas");
        dist.setModelShortName("RPaM");
        dist.setModelLongName("Representation Powers and Mandates");
        dist.setModelVersion("1.0");
        dist.setCanonicalURI("urn:eu:digit:isa:names:specification:rpam");
        dist.setCanonicalVesionURI("urn:eu:digit:isa:names:specification:rpam:1.0");
        dist.setLocationURI("https://github.com/everis-rpam/RPaM-Ontology");
        dist.setAgencyLongName("Interoperability Solutions for Public Administrations, programme");
        dist.setAgencyIdentifier("ISA2");

        Parameter v1 = new Parameter(
                "UBLversion",
                "2.3",
                "The UBL version used for the generation of this distribution package.",
                "String",
                "${UBLversion}");

        Parameter v2 = new Parameter(
                "UBLprevVersion",
                "2.2",
                "The UBL version immediately prior to the one used for the generation of the W3C schemas.",
                "String",
                "${UBLprevVersion}");

        Parameter v3 = new Parameter(
                "ABIEextensions",
                "yes",
                "Override this as ‘no’ for UBL 2.2 and earlier.",
                "String",
                "${ABIEextensions}");

        Parameters vars = new Parameters();
        vars.put("UBLversion", v1);
        vars.put("UBLprevVersion", v2);
        vars.put("ABIEextension", v3);

        Parameter i1 = new Parameter(
                "UBLversion",
                "2.3",
                "The UBL version used for the generation of this distribution package.",
                "String",
                "${UBLversion}");

        Parameter i2 = new Parameter(
                "UBLprevVersion",
                "2.2",
                "The UBL version immediately prior to the one used for the generation of the W3C schemas.",
                "String",
                "${UBLprevVersion}");

        Parameter i3 = new Parameter(
                "ABIEextensions",
                "yes",
                "Override this as ‘no’ for UBL 2.2 and earlier.",
                "String",
                "${ABIEextensions}");

        Parameters in = new Parameters();
        in.put("UBLversion", i1);
        in.put("UBLprevVersion", i2);
        in.put("ABIEextension", i3);

        Parameter o1 = new Parameter(
                "UBLversion",
                "2.3",
                "The UBL version used for the generation of this distribution package.",
                "String",
                "${UBLversion}");

        Parameter o2 = new Parameter(
                "UBLprevVersion",
                "2.2",
                "The UBL version immediately prior to the one used for the generation of the W3C schemas.",
                "String",
                "${UBLprevVersion}");

        Parameter o3 = new Parameter(
                "ABIEextensions",
                "yes",
                "Override this as ‘no’ for UBL 2.2 and earlier.",
                "String",
                "${ABIEextensions}");

        Parameters out = new Parameters();
        out.put("UBLversion", i1);
        out.put("UBLprevVersion", i2);
        out.put("ABIEextension", i3);

        Configuration conf = new Configuration();
        conf.setDist(dist);
        conf.setGlobalVar(vars);
        conf.setInputFiles(in);
        conf.setOutputDirs(out);

        String json = new Gson().toJson(conf);



    }
}
