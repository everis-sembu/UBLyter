<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
  <xsl:template name="confMetadata">
      <xsl:param name="modelName"/>
      <xsl:param name="longName"/>
      
    <ShortName><xsl:value-of select="$modelName"/></ShortName>      
    <LongName><xsl:value-of select="$longName"/></LongName>
    <Version>2.3</Version>
    <CanonicalUri>urn:oasis:names:specification:ubl:BIE</CanonicalUri>
    <CanonicalVersionUri>urn:oasis:names:specification:ubl:BIE:2.3</CanonicalVersionUri>
    <LocationUri>http://docs.oasis-open.org/ubl/preaward02-UBL-2.3/mod/UBL-Entities-2.3.gc</LocationUri>
    <Agency>
        <LongName xml:lang="en">OASIS Universal Business Language</LongName>
        <Identifier>UBL</Identifier>
    </Agency>
</xsl:template>
</xsl:stylesheet>