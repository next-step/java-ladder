package ladder.domain.content.user;

public class Gamer {
    private final Name name;
    
    private Gamer(final String name) {
        this.name = Name.newEnglishNumericOf(name);
    }
    
    public static Gamer of(String name) {
        return new Gamer(name);
    }
}
