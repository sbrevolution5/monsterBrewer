package sb.monsterBrewer.services;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import sb.monsterBrewer.dtos.CompendiumXml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class xmlServiceTest {

    @Test
    void readMonsterXml() throws ParserConfigurationException, IOException, SAXException {

    }

    @Test
    void readCompendiumXml() throws XMLStreamException, JAXBException, FileNotFoundException {
        XmlService service = new XmlService();
        service.readCompendiumXml();
        JAXBElement<CompendiumXml> res = service.unmarshal("F:\\CoderFoundry\\Java\\monsterBrewer\\monsterBrewer\\src\\main\\java\\sb\\monsterBrewer\\exampleXml\\MonsterManualCompendium.xml");
        System.out.println(Arrays.stream(res.getValue().getMonster()).findAny());
    }

    @Test
    void unmarshal() {
    }
}