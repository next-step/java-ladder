package ladder.domain;

public class Participant {
    private Name name;
    private int startIndex;

    private Participant(Name name, int startIndex) {
        this.startIndex = startIndex;
        this.name = name;
    }

    public static Participant of(String nameInput, int index) {
        Name name = Name.from(nameInput);
        return new Participant(name, index);
    }

    public Name getName() {
        return name;
    }

    public int getStartIndex() {
        return startIndex;
    }

}
