package ladder.domain.gamer.info;

import java.util.Objects;

public class Gamer {
    private final Name name;
    
    private Gamer(final String name) {
        this.name = Name.newEnglishNumericOf(name);
    }
    
    public static Gamer from(final String name) {
        return new Gamer(name);
    }
    
    public String getName() {
        return name.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(getName(), gamer.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
