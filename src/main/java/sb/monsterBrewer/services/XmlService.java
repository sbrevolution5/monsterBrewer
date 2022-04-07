package sb.monsterBrewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import sb.monsterBrewer.dtos.CompendiumXml;
import sb.monsterBrewer.models.Compendium;
import sb.monsterBrewer.models.Monster;


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
    public String marshal(Monster monster) throws JAXBException, IOException, XMLStreamException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Monster.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(monster,sw );
        return sw.toString();
    }
    public JAXBElement<CompendiumXml> unmarshal(String filename) throws JAXBException, XMLStreamException, FileNotFoundException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(filename));
        return unmarshaller.unmarshal(reader, CompendiumXml.class);
    }
    public JAXBElement<CompendiumXml> unmarshalXml(String xml) throws JAXBException, XMLStreamException {
        readCompendiumXml();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xml));
        return unmarshaller.unmarshal(reader, CompendiumXml.class);
    }
}
