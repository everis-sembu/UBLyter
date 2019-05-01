package com.everis.sembu.blyter.conf;

public class Configuration {

    protected Parameters
                distribution  = null,
                globalVars    = null,
                inputFiles    = null,
                outputDirs    = null;

    public Parameters getDistribution() {
        return distribution;
    }

    public void setDist(Parameters distribution) {
        this.distribution = distribution;
    }

    public Parameters getGlobalVars() {
        return globalVars;
    }

    public void setGlobalVars(Parameters globalVar) {
        this.globalVars = globalVar;
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

    public String getInputDir(String key) throws DirectoryNotFoundException {
        if (this.inputFiles.get(key).getType().toUpperCase() != "DIRECTORY")
            throw new DirectoryNotFoundException();

        return this.inputFiles.get(key).getSymbol();
    }

    public String getInputFile(String key) throws FileNotFoundException {
        if (this.inputFiles.get(key).getType().toUpperCase() != "FILE")
            throw new FileNotFoundException();

        return this.inputFiles.get(key).getValue();
    }

    public String getOutputDir(String key){
        return this.outputDirs.get(key).getValue();
    }

}
