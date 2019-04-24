package com.everis.sembu.blyter.conf;

public class Distribution {


    protected String title               = null;
    protected String description         = null;
    protected String modelShortName      = null;
    protected String modelLongName       = null;
    protected String modelVersion        = null;
    protected String canonicalURI        = null;
    protected String canonicalVesionURI  = null;
    protected String locationURI         = null;
    protected String agencyLongName      = null;
    protected String agencyIdentifier    = null;

    public Distribution(){

    }

    public Distribution(String title,
                        String description,
                        String modelShortName,
                        String modelLongName,
                        String modelVersion,
                        String canonicalURI,
                        String canonicalVesionURI,
                        String locationURI,
                        String agencyLongName,
                        String agencyIdentifier) {

        this.title = title;
        this.description = description;
        this.modelShortName = modelShortName;
        this.modelVersion = modelVersion;
        this.canonicalURI = canonicalURI;
        this.canonicalVesionURI = canonicalVesionURI;
        this.locationURI = locationURI;
        this.agencyLongName = agencyLongName;
        this.agencyIdentifier = agencyIdentifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModelShortName() {
        return modelShortName;
    }

    public void setModelShortName(String modelShortName) {
        this.modelShortName = modelShortName;
    }

    public String getModelLongName() {return modelLongName;}

    public void setModelLongName(String modelLongName) {this.modelLongName = modelLongName;}

    public String getModelVersion() { return modelVersion;}

    public void setModelVersion(String modelVersion) {this.modelVersion = modelVersion;}

    public String getCanonicalURI() {
        return canonicalURI;
    }

    public void setCanonicalURI(String canonicalURI) {
        this.canonicalURI = canonicalURI;
    }

    public String getCanonicalVesionURI() {
        return canonicalVesionURI;
    }

    public void setCanonicalVesionURI(String canonicalVesionURI) {
        this.canonicalVesionURI = canonicalVesionURI;
    }

    public String getLocationURI() {
        return locationURI;
    }

    public void setLocationURI(String locationURI) {
        this.locationURI = locationURI;
    }

    public String getAgencyLongName() {
        return agencyLongName;
    }

    public void setAgencyLongName(String agencyLongName) {
        this.agencyLongName = agencyLongName;
    }

    public String getAgencyIdentifier() {
        return agencyIdentifier;
    }

    public void setAgencyIdentifier(String agencyIdentifier) {
        this.agencyIdentifier = agencyIdentifier;
    }
}
