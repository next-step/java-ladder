package game.ladder.domain;

public class Participant implements Comparable<Participant>{

    private final Name name;
    private final Position position;

    public Participant(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public String formattedParticipantName() {
        return this.name.fomattedName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (!name.equals(that.name)) return false;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public int compareTo(Participant other) {
        return this.position.compareTo(other.position);
    }
}
