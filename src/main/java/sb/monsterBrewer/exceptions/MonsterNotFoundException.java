package sb.monsterBrewer.exceptions;

public class MonsterNotFoundException extends RuntimeException{
    public MonsterNotFoundException(Long id){
        super("Could not find monster "+id);
    }
}
