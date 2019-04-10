<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0" 
    xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0" 
    xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0" 
    xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0" 
    xmlns:b="urn:X:everis:sembu:blyter:0.1"
    xmlns:gc="http://docs.oasis-open.org/codelist/ns/genericode/1.0/"
    exclude-result-prefixes="xs office style table text b" 
    version="2.0">
    
    <xsl:import href="methods.xsl"/>

    <xsl:template name="confMetadata">
        <Identification>
            <xsl:for-each select="table:table-row/table:table-cell">
                <xsl:variable name="p" select="."/>
                <xsl:choose>
                    <xsl:when test="$p = 'Model name:'">
                        <ShortName><xsl:value-of select="b:getCellContent(.,3)"/></ShortName>
                    </xsl:when>
                    <xsl:when test="$p = 'Model Long Name:'">
                        <LongName><xsl:value-of select="b:getCellContent(.,3)"/></LongName>
                    </xsl:when>
                    <xsl:when test="$p = 'Canonical URI:'">
                        <CanonicalUri><xsl:value-of select="b:getCellContent(.,3)"/></CanonicalUri>
                    </xsl:when>
                    <xsl:when test="$p = 'Canonical Version URI:'">
                        <CanonicalVersionUri><xsl:value-of select="b:getCellContent(.,3)"/></CanonicalVersionUri>
                    </xsl:when>
                    <xsl:when test="$p = 'Location URI:'">
                        <LocationUri><xsl:value-of select="b:getCellContent(.,3)"/></LocationUri>
                    </xsl:when>                    
                    <xsl:when test="$p = 'Agency Long Name:'">
                        <Agency>
                            <LongName><xsl:value-of select="b:getCellContent(.,3)"/></LongName>
                            <Identifier><xsl:value-of select="./ancestor::table:table-row/following-sibling::node()/table:table-cell[3]/text:p"/></Identifier>
                        </Agency>
                    </xsl:when>
                </xsl:choose>                
            </xsl:for-each>
        </Identification>
    </xsl:template>
</xsl:stylesheet>