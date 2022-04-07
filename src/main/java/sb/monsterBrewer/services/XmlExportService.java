package sb.monsterBrewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import sb.monsterBrewer.dtos.CompendiumXml;
import sb.monsterBrewer.models.Compendium;

import javax.xml.bind.*;
import javax.xml.stream.*;
import java.io.*;

public class XmlExportService {
    @Autowired
    private JAXBContext jaxbContext;
    public void readCompendiumXml(){
        try{
            jaxbContext= JAXBContext.newInstance(CompendiumXml.class);
        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
    public String marshal(Compendium compendium) throws JAXBException, IOException, XMLStreamException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Compendium.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(compendium,sw );
        return sw.toString();
    }
}
