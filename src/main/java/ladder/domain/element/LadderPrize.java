package ladder.domain.element;

import ladder.domain.common.Printable;

public class LadderPrize implements Printable {

    private final Persons.Person person;
    private final Prizes.Prize prize;

    public LadderPrize(Persons.Person person, Prizes.Prize prize) {
        this.person = person;
        this.prize = prize;
    }

    public Persons.Person getPerson() {
        return person;
    }

    public Prizes.Prize getPrize() {
        return prize;
    }

    @Override
    public String print() {
        return person.getName() + ": " + prize.getName();
    }
}
