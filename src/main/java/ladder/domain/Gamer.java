package ladder.domain;

public class Gamer implements Comparable<Gamer> {
    private String name;

    public Gamer(String name) {
        this.name = name;
    }

    public int getNameLength() {
        return name.length();
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
}
