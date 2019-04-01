package ladder.dto;

import java.util.Objects;

public class Gamer implements Comparable<Gamer> {
    private String name;

    private Result result;

    public Gamer(String name) {
        this.name = name;
    }

    public int getNameLength() {
        return name.length();
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public int compareTo(Gamer otherGamer) {
        if (name.length() > otherGamer.name.length()) {
            return 1;
        } else if (name.length() < otherGamer.name.length()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
