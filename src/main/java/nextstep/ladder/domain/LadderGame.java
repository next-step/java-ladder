package nextstep.ladder.domain;

public class LadderGame {

    private final Persons persons;
    private final Heights heights;

    public LadderGame(Persons persons, int heightCount) {
        this.persons = persons;
        this.heights = new Heights(persons.personCount(), heightCount);
    }


    public Persons getPersons() {
        return persons;
    }

    public Heights getHeights() {
        return heights;
    }

    public int maxLength(){
        return this.persons.getMaxLength();
    }
}
