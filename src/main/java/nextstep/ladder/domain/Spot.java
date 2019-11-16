package nextstep.ladder.domain;

import java.util.Objects;

public class Spot {

    private String name;
    private int point;

    public Spot(String name, int point) {
        if ("".equals(name.trim())) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot user = (Spot) o;
        return point == user.point &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, point);
    }

    @Override
    public String toString() {
        int length = name.length();
        int space = Math.max(0, 5 - length);
        String spaceString = "";
        for (int i = 0; i < space; i++) {
            spaceString = spaceString + " ";
        }

        return name + spaceString;
    }
}
