package nextstep.ladder.domain;

import java.util.Objects;

public class Participator {

    private final String name;

    public Participator(String name) {
        this.name = name.length() > 5 ? name.substring(0, 5) : name;
    }

    public String makeFullName() {
        if (name.length() == 5) {
            return " " + name;
        }

        String tempName = "     " + name + " ";
        return tempName.substring(tempName.length() - 6);
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
