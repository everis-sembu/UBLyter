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
    
    <xsl:template name="columnSet">
        <ColumnSet>
            <Column Id="ModelName" Use="required">
                <ShortName>ModelName</ShortName>
                <LongName>Model Name</LongName>
                <Data Type="string"/>
            </Column>
            <Column Id="PathName" Use="required">
                <ShortName>PathName</ShortName>
                <LongName>Path Name</LongName>
                <Data Type="string"/>
            </Column>
            <Column Id="Path" Use="required">
                <ShortName>Path</ShortName>
                <LongName>Path</LongName>
                <Data Type="string"/>
            </Column>
            <Column Id="Description" Use="optional">
                <ShortName>Description</ShortName>
                <LongName>Description</LongName>
                <Data Type="string"/>
            </Column>
            <Column Id="Type" Use="required">
                <ShortName>Type</ShortName>
                <LongName>Entry Type</LongName>
                <Data Type="string"/>
            </Column>
            <Column Id="Symbol" Use="required">
                <ShortName>Symbol</ShortName>
                <LongName>Internal Symbol</LongName>
                <Data Type="string"/>
            </Column>
        </ColumnSet>
    </xsl:template>
</xsl:stylesheet>