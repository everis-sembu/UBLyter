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
    
    <xsl:function name="b:getCellContent">
        <xsl:param name="node"/>
        <xsl:param name="colpos"/>
        <xsl:value-of select="$node/ancestor::table:table-row/table:table-cell[sum(preceding-sibling::*/@table:number-columns-repeated) + position() - count(preceding-sibling::*/@table:number-columns-repeated) &lt;= $colpos][last()]/text:p/text()"/>	
    </xsl:function>
    

</xsl:stylesheet>