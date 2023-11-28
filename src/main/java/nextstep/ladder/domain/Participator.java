package nextstep.ladder.domain;

import java.util.Objects;

public class Participator {

    private final String name;
    private String result;

    public Participator(String name) {
        this.name = name.length() > 5 ? name.substring(0, 5) : name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participator that = (Participator) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
