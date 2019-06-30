package ladder.domain.gamer.info;

public class Gamer {
    private final Name name;
    
    private Gamer(final String name) {
        this.name = Name.newEnglishNumericOf(name);
    }
    
    public static Gamer of(String name) {
        return new Gamer(name);
    }
    
    public String getName() {
        return name.toString();
    }
}
