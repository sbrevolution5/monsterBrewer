package sb.monsterBrewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sb.monsterBrewer.dtos.CompendiumXml;
import sb.monsterBrewer.models.Monster;


import javax.sql.rowset.spi.XmlReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlService {
    @Autowired
    private JAXBContext jaxbContext;
    public void readCompendiumXml(){
        try{
            jaxbContext= JAXBContext.newInstance(CompendiumXml.class);
        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
    public JAXBElement<CompendiumXml> unmarshal(String filename) throws JAXBException, XMLStreamException, FileNotFoundException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(filename));
        return unmarshaller.unmarshal(reader, CompendiumXml.class);
    }
}
