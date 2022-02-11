package sb.monsterBrewer.services;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class xmlServiceTest {

    @Test
    void readMonsterXml() throws ParserConfigurationException, IOException, SAXException {
        XmlService service = new XmlService();
        service.readMonsterXml( "F:\\CoderFoundry\\Java\\monsterBrewer\\monsterBrewer\\src\\main\\java\\sb\\monsterBrewer\\exampleXml\\MonsterManualCompendium.xml");

    }
}