package sb.monsterBrewer.services;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import sb.monsterBrewer.dtos.CompendiumXml;
import sb.monsterBrewer.dtos.MonsterXml;
import sb.monsterBrewer.models.Action;
import sb.monsterBrewer.models.Compendium;
import sb.monsterBrewer.models.Monster;
import sb.monsterBrewer.models.Trait;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class xmlServiceTest {
    @Test
    void readMonsterXml() {

    }

    @Test
    void readCompendiumXml() throws XMLStreamException, JAXBException, FileNotFoundException {
        Monster expectedMonster = new Monster();

        XmlService service = new XmlService();
        service.readCompendiumXml();
        JAXBElement<CompendiumXml> res = service.unmarshal("F:\\CoderFoundry\\Java\\monsterBrewer\\monsterBrewer\\src\\main\\java\\sb\\monsterBrewer\\exampleXml\\MonsterManualCompendium.xml");
        XmlToDbService dbService = new XmlToDbService();
        var monster = dbService.parseMonster(res.getValue().getMonster()[0]);
        assertEquals(11, monster.getCharisma());
        assertEquals(10, monster.getStrength());
        assertEquals(14,monster.getDexterity());
        assertEquals(10, monster.getConstitution());
        assertEquals(11, monster.getIntelligence());
        assertEquals(12, monster.getWisdom());
        assertEquals("13 (3d8)", monster.getHp());
        assertEquals("Neutral Good", monster.getAlignment());
        assertEquals("12", monster.getAc());
        assertEquals("M", monster.getSize());
        assertEquals("Aarakocra", monster.getName());
        assertEquals(5,monster.getPerception());
        assertEquals("15",monster.getPassive());
        assertEquals("Auran, Aarakocra", monster.getLanguages());
        assertEquals("1/4", monster.getCr());
        assertEquals("Dive Attack", monster.getTraits().get(0).getName());
        assertEquals("If the aarakocra is flying and dives at least 30 feet straight toward a target and then hits it with a melee weapon attack, the attack deals an extra 3 (1d6) damage to the target.", monster.getTraits().stream().findFirst().orElse(null).getDescription());
        assertEquals("Talon", monster.getActions().get(0).getName());
        assertEquals("Melee Weapon Attack: +4 to hit, reach 5 ft., one target. 4 (1d4 + 2) slashing damage.",monster.getActions().get(0).getDescription());
        assertEquals("Aarakocra range the Howling Gyre, an endless storm of mighty winds and lashing rains that surrounds the tranquil realm of Aaqa in the Elemental Plane of Air. Making aerial patrols, these birdlike humanoids guard the windy borders of their home against invaders from the Elemental Plane of Earth, such as gargoyles, their sworn enemies.\n" +
                "            Enemies of Elemental Evil. In service to the Wind Dukes of Aaqa, aarakocra scout the planes in search of temples of Elemental Evil. They spy on malign elemental creatures and then either take the fight to those creatures or report back to the Wind Dukes.\n" +
                "            On the Material Plane, aarakocra create aeries atop the highest mountains, especially peaks near portals to the Elemental Plane of Air. From such heights, aarakocra watch for signs of elemental incursions, as well as for nascent threats to their home plane. Aarakocra prefer to live their lives like the wind-unburdened and ever moving-yet they watch over a region for years if that's what it takes to guard against the incursions of Elemental Evil.\n" +
                "            Aarakocra have no concept of political borders or property ownership, and the value of gems, gold, and other precious materials means little to aarakocra. In their eyes, a creature should use what is necessary and then cast what is left on the wind for others to use.\n" +
                "            Search for the Seven Shards. The Wind Dukes of Aaqa come from a type of elemental beings called the vaati, which once ruled many worlds. A creature known as the Queen of Chaos arose and initiated an interplanar war against vaati rule. To combat the threat, seven vaati heroes combined their powers to create the mighty Rod of Law. In a battle against the queen's greatest general, Mishka the Wolf Spider, a vaati killed Mishka by thrusting the rod into him like a spear. The rod shattered into seven shards that scattered across the multiverse. Aaracokra seek signs of the pieces' locations in order to rebuild what is now known as the Rod of Seven Parts.\n" +
                "            Summoning Air Elementals.\n" +
                "            ------\n" +
                "            Five aarakocra within 30 feet of each other can magically summon an air elemental. Each of the five must use its action and movement on three consecutive turns to perform an aerial dance and must maintain concentration while doing so (as if concentrating on a spell). When all five have finished their third turn of the dance, the elemental appears in an unoccupied space within 60 feet of them. It is friendly toward them and obeys their spoken commands. It remains for 1 hour, until it or all its summoners die, or until any of its summoners dismisses it as a bonus action. A summoner can't perform the dance again until it finishes a short rest. When the elemental returns to the Elemental Plane of Air, any aarakocra within 5 feet of it can return with it.\n" +
                "            ------\n" +
                "            Source: Monster Manual p. 12, Princes of the Apocalypse, Storm King's Thunder, Tomb of Annihilation, Explorer's Guide to Wildemount, Icewind Dale: Rime of the Frostmaiden", monster.getDescription());
        assertEquals("mountain", monster.getEnvironment());
    }

    @Test
    void marshalTest() throws XMLStreamException, JAXBException, IOException {
        //arrange
        Monster m = new Monster();
        m.setName("Aarakocra");
        m.setSize("M");
        m.setStrength(10);
        m.setDexterity(14);
        m.setConstitution(10);
        m.setIntelligence(11);
        m.setWisdom(12);
        m.setCharisma(11);
        m.setPerception(5);
        m.setPassive("15");
        m.setLanguages("Auran, Aarakocra");
        m.setCr("1/4");
        Trait t1 = new Trait();
        t1.setName("Dive Attack");
        t1.setDescription("If the aarakocra is flying and dives at least 30 feet straight toward a target and then hits it with a melee weapon attack, the attack deals an extra 3 (1d6) damage to the target.");
        t1.setMonster(m);
        m.getTraits().add(t1);
        Action a1 = new Action();
        a1.setMonster(m);
        a1.setName("Talon");
        a1.setDescription("Melee Weapon Attack: +4 to hit, reach 5 ft., one target. 4 (1d4 + 2) slashing damage.");
        a1.setAttack("Talon|+4|1d4+2");
        m.getActions().add(a1);
        Action a2 = new Action();
        a2.setMonster(m);
        a2.setName("Javelin");
        a2.setDescription("Melee or Ranged Weapon Attack: +4 to hit, reach 5 ft. or range 30/120 ft., one target. 5 (1d6 + 2) piercing damage.");
        a2.setAttack("Javelin|+4|1d6+2");
        m.getActions().add(a2);
        Action a3 = new Action();
        a3.setMonster(m);
        a3.setName("Summon Air Elemental");
        a3.setDescription("Five aarakocra within 30 feet of each other can magically summon an air elemental. Each of the five must use its action and movement on three consecutive turns to perform an aerial dance and must maintain concentration while doing so (as if concentrating on a spell). When all five have finished their third turn of the dance, the elemental appears in an unoccupied space within 60 feet of them. It is friendly toward them and obeys their spoken commands. It remains for 1 hour, until it or all its summoners die, or until any of its summoners dismisses it as a bonus action. A summoner can't perform the dance again until it finishes a short rest. When the elemental returns to the Elemental Plane of Air, any aarakocra within 5 feet of it can return with it.");
        m.getActions().add(a3);
        m.setDescription("Aarakocra range the Howling Gyre, an endless storm of mighty winds and lashing rains that surrounds the tranquil realm of Aaqa in the Elemental Plane of Air. Making aerial patrols, these birdlike humanoids guard the windy borders of their home against invaders from the Elemental Plane of Earth, such as gargoyles, their sworn enemies.\n" +
                "        Enemies of Elemental Evil. In service to the Wind Dukes of Aaqa, aarakocra scout the planes in search of temples of Elemental Evil. They spy on malign elemental creatures and then either take the fight to those creatures or report back to the Wind Dukes.\n" +
                "        On the Material Plane, aarakocra create aeries atop the highest mountains, especially peaks near portals to the Elemental Plane of Air. From such heights, aarakocra watch for signs of elemental incursions, as well as for nascent threats to their home plane. Aarakocra prefer to live their lives like the wind-unburdened and ever moving-yet they watch over a region for years if that's what it takes to guard against the incursions of Elemental Evil.\n" +
                "        Aarakocra have no concept of political borders or property ownership, and the value of gems, gold, and other precious materials means little to aarakocra. In their eyes, a creature should use what is necessary and then cast what is left on the wind for others to use.\n" +
                "        Search for the Seven Shards. The Wind Dukes of Aaqa come from a race of elemental beings called the vaati, which once ruled many worlds. A creature known as the Queen of Chaos arose and initiated an interplanar war against vaati rule. To combat the threat, seven vaati heroes combined their powers to create the mighty Rod of Law. In a battle against the queen's greatest general, Mishka the Wolf Spider, a vaati killed Mishka by thrusting the rod into him like a spear. The rod shattered into seven shards that scattered across the multiverse. Aaracokra seek signs of the pieces' locations in order to rebuild what is now known as the Rod of Seven Parts.\n" +
                "        Summoning Air Elementals.\n" +
                "        ------\n" +
                "        Five aarakocra within 30 feet of each other can magically summon an air elemental. Each of the five must use its action and movement on three consecutive turns to perform an aerial dance and must maintain concentration while doing so (as if concentrating on a spell). When all five have finished their third turn of the dance, the elemental appears in an unoccupied space within 60 feet of them. It is friendly toward them and obeys their spoken commands. It remains for 1 hour, until it or all its summoners die, or until any of its summoners dismisses it as a bonus action. A summoner can't perform the dance again until it finishes a short rest. When the elemental returns to the Elemental Plane of Air, any aarakocra within 5 feet of it can return with it.\n" +
                "        ------\n" +
                "        Source: Monster Manual p. 12, Princes of the Apocalypse, Storm King's Thunder, Tomb of Annihilation, Explorer's Guide to Wildemount, Icewind Dale: Rime of the Frostmaiden");
        m.setEnvironment("mountain");
        XmlService service = new XmlService();
        DbToXmlService dbToXmlService = new DbToXmlService();
        //act
        MonsterXml mx = dbToXmlService.unparseMonster(m);
        var res = service.marshal(mx);
        //assert
        String aarakocra = "<compendium>\n" +
                "    <monster>\n" +
                "        <name>Aarakocra</name>\n" +
                "        <size>M</size>\n" +
                "        <type>humanoid (aarakocra)</type>\n" +
                "        <alignment>Neutral Good</alignment>\n" +
                "        <ac>12</ac>\n" +
                "        <hp>13 (3d8)</hp>\n" +
                "        <speed>walk 20 ft., fly 50 ft.</speed>\n" +
                "        <str>10</str>\n" +
                "        <dex>14</dex>\n" +
                "        <con>10</con>\n" +
                "        <int>11</int>\n" +
                "        <wis>12</wis>\n" +
                "        <cha>11</cha>\n" +
                "        <save></save>\n" +
                "        <skill>Perception +5</skill>\n" +
                "        <passive>15</passive>\n" +
                "        <languages>Auran, Aarakocra</languages>\n" +
                "        <cr>1/4</cr>\n" +
                "        <resist></resist>\n" +
                "        <immune></immune>\n" +
                "        <vulnerable></vulnerable>\n" +
                "        <conditionImmune></conditionImmune>\n" +
                "        <senses></senses>\n" +
                "        <trait>\n" +
                "            <name>Dive Attack</name>\n" +
                "            <text>If the aarakocra is flying and dives at least 30 feet straight toward a target and then hits it with a melee weapon attack, the attack deals an extra 3 (1d6) damage to the target.</text>\n" +
                "        </trait>\n" +
                "        <action>\n" +
                "            <name>Talon</name>\n" +
                "            <text>Melee Weapon Attack: +4 to hit, reach 5 ft., one target. 4 (1d4 + 2) slashing damage.</text>\n" +
                "            <attack>Talon|+4|1d4+2</attack>\n" +
                "        </action>\n" +
                "        <action>\n" +
                "            <name>Javelin</name>\n" +
                "            <text>Melee or Ranged Weapon Attack: +4 to hit, reach 5 ft. or range 30/120 ft., one target. 5 (1d6 + 2) piercing damage.</text>\n" +
                "            <attack>Javelin|+4|1d6+2</attack>\n" +
                "        </action>\n" +
                "        <action>\n" +
                "            <name>Summon Air Elemental</name>\n" +
                "            <text>Five aarakocra within 30 feet of each other can magically summon an air elemental. Each of the five must use its action and movement on three consecutive turns to perform an aerial dance and must maintain concentration while doing so (as if concentrating on a spell). When all five have finished their third turn of the dance, the elemental appears in an unoccupied space within 60 feet of them. It is friendly toward them and obeys their spoken commands. It remains for 1 hour, until it or all its summoners die, or until any of its summoners dismisses it as a bonus action. A summoner can't perform the dance again until it finishes a short rest. When the elemental returns to the Elemental Plane of Air, any aarakocra within 5 feet of it can return with it.</text>\n" +
                "        </action>\n" +
                "        <description>Aarakocra range the Howling Gyre, an endless storm of mighty winds and lashing rains that surrounds the tranquil realm of Aaqa in the Elemental Plane of Air. Making aerial patrols, these birdlike humanoids guard the windy borders of their home against invaders from the Elemental Plane of Earth, such as gargoyles, their sworn enemies.\n" +
                "        Enemies of Elemental Evil. In service to the Wind Dukes of Aaqa, aarakocra scout the planes in search of temples of Elemental Evil. They spy on malign elemental creatures and then either take the fight to those creatures or report back to the Wind Dukes.\n" +
                "        On the Material Plane, aarakocra create aeries atop the highest mountains, especially peaks near portals to the Elemental Plane of Air. From such heights, aarakocra watch for signs of elemental incursions, as well as for nascent threats to their home plane. Aarakocra prefer to live their lives like the wind-unburdened and ever moving-yet they watch over a region for years if that's what it takes to guard against the incursions of Elemental Evil.\n" +
                "        Aarakocra have no concept of political borders or property ownership, and the value of gems, gold, and other precious materials means little to aarakocra. In their eyes, a creature should use what is necessary and then cast what is left on the wind for others to use.\n" +
                "        Search for the Seven Shards. The Wind Dukes of Aaqa come from a race of elemental beings called the vaati, which once ruled many worlds. A creature known as the Queen of Chaos arose and initiated an interplanar war against vaati rule. To combat the threat, seven vaati heroes combined their powers to create the mighty Rod of Law. In a battle against the queen's greatest general, Mishka the Wolf Spider, a vaati killed Mishka by thrusting the rod into him like a spear. The rod shattered into seven shards that scattered across the multiverse. Aaracokra seek signs of the pieces' locations in order to rebuild what is now known as the Rod of Seven Parts.\n" +
                "        Summoning Air Elementals.\n" +
                "        ------\n" +
                "        Five aarakocra within 30 feet of each other can magically summon an air elemental. Each of the five must use its action and movement on three consecutive turns to perform an aerial dance and must maintain concentration while doing so (as if concentrating on a spell). When all five have finished their third turn of the dance, the elemental appears in an unoccupied space within 60 feet of them. It is friendly toward them and obeys their spoken commands. It remains for 1 hour, until it or all its summoners die, or until any of its summoners dismisses it as a bonus action. A summoner can't perform the dance again until it finishes a short rest. When the elemental returns to the Elemental Plane of Air, any aarakocra within 5 feet of it can return with it.\n" +
                "        ------\n" +
                "        Source: Monster Manual p. 12, Princes of the Apocalypse, Storm King's Thunder, Tomb of Annihilation, Explorer's Guide to Wildemount, Icewind Dale: Rime of the Frostmaiden</description>\n" +
                "        <environment>mountain</environment>\n" +
                "    </monster>\n" +
                "</compendium>";
        assertEquals(res, aarakocra);

    }
}