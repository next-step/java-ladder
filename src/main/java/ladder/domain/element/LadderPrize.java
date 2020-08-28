package ladder.domain.element;

import ladder.domain.common.Printable;

public class LadderPrize implements Printable {

    private final Person person;
    private final Prize prize;

    public LadderPrize(Person person, Prize prize) {
        this.person = person;
        this.prize = prize;
    }

    public Person getPerson() {
        return person;
    }

    public Prize getPrize() {
        return prize;
    }

    @Override
    public String print() {
        return person.getName() + ": " + prize.getName();
    }
}
