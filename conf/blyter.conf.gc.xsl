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

    <xsl:import href="support-gc/methods.xsl"/>
    <xsl:import href="support-gc/confMetadata.xsl"/>
    <xsl:import href="support-gc/columnSet.xsl"/>
    <xsl:import href="support-gc/tab.xsl"/>
    

    <xsl:function name="b:getCellContent">
        <xsl:param name="node"/>
        <xsl:param name="colpos"/>
        <xsl:value-of select="$node/ancestor::table:table-row/table:table-cell[sum(preceding-sibling::*/@table:number-columns-repeated) + position() - count(preceding-sibling::*/@table:number-columns-repeated) &lt;= $colpos][last()]/text:p/text()"/>	
    </xsl:function>


    <xsl:template match="/" priority="1">
        <xsl:apply-templates/>
    </xsl:template>
    
    <xsl:template match="office:body">
		<gc:CodeList>
		    <xsl:apply-templates/>
		</gc:CodeList>
	</xsl:template>

    <!-- Tab control -->
    <xsl:template match="office:spreadsheet/table:table" priority="2">
        <xsl:text disable-output-escaping="yes">&lt;</xsl:text>SimpleCodeList<xsl:text disable-output-escaping="yes">&gt;</xsl:text>
        <xsl:choose>
            <xsl:when test="@table:name='distribution'">
                <xsl:call-template name="confMetadata"/>
                <xsl:call-template name="columnSet"></xsl:call-template>    
            </xsl:when>
            <xsl:otherwise>
                <xsl:call-template name="tab">
                    <xsl:with-param name="tabName" select="@table:name"/>
                </xsl:call-template>
            </xsl:otherwise>  
        </xsl:choose>
        <xsl:text disable-output-escaping="yes">&lt;/</xsl:text>SimpleCodeList<xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
	</xsl:template>
</xsl:stylesheet>