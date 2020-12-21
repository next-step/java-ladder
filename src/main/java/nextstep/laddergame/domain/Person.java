package nextstep.laddergame.domain;

public class Person {
    private Name name;
    private int sequence;
    private int resultIndex;

    private Person(String name) {
        this.name = Name.create(name);
    }

    public Person(String name, int sequence) {
        this.name = Name.create(name);
        this.sequence = sequence;
    }

    public static Person from(String name) {
        return new Person(name);
    }

    public static Person of(String name, int sequence) {
        return new Person(name, sequence);
    }

    public String getName() {
        return this.name.getName();
    }
  
    public void runLadder(Ladder ladder) {
        int index = this.sequence;
        for (Line line : ladder.getLines()) {
            index = line.moveByIndex(index);
        }

        this.resultIndex = index;
    }

    public int getResultIndex() {
        return resultIndex;
    }
}
