package nextstep.ladder.domain;

import java.util.Objects;

public class Participator {

    private final String name;
    private int location;

    public Participator(String name, int location) {
        if (name.length() > 5) {
            name = name.substring(0, 5);
        }
        this.name = name;
        this.location = location;
    }

    public void goLeft() {
        location--;
    }

    public void goRight() {
        location++;
    }

    public String makeFullName() {
        if (name.length() == 5) {
            return " " + name;
        }

        String tempName = "     " + name + " ";
        return tempName.substring(tempName.length() - 6);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participator that = (Participator) o;
        return location == that.location && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
