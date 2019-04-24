package com.everis.sembu.blyter.conf;

public class Configuration {

    protected Distribution distribution  = null;
    protected Parameters   globalVar     = null;
    protected Parameters   inputFiles    = null;
    protected Parameters   outputDirs    = null;

    public Distribution getDist() {
        return distribution;
    }

    public void setDist(Distribution dist) {
        this.distribution = dist;
    }

    public Parameters getGlobalVar() {
        return globalVar;
    }

    public void setGlobalVar(Parameters globalVar) {
        this.globalVar = globalVar;
    }

    public Parameters getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(Parameters inputFiles) {
        this.inputFiles = inputFiles;
    }

    public Parameters getOutputDirs() {
        return outputDirs;
    }

    public void setOutputDirs(Parameters outputDirs) {
        this.outputDirs = outputDirs;
    }

    public String inDir(String key){
        return this.inputFiles.get(key).getSymbol();
    }

    public String outDir(String key){
        return this.outputDirs.get(key).getSymbol();
    }

}
