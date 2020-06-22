package ladder.domain;

public class LadderGameInfo {

    private final Persons persons;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGameInfo(Persons persons, Ladder ladder, Prizes prizes) {
        this.persons = persons;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public Persons getPersons() {
        return persons;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
