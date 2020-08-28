package ladder.domain;

import ladder.domain.common.Printable;
import ladder.domain.element.*;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.common.LadderMessage.PERSON_PRIZE_SIZE_MESSAGE;

public class LadderGame implements Printable {

    private final Persons persons;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(Persons persons, Ladder ladder, Prizes prizes) {
        checkArgument(persons.size() == prizes.size(), PERSON_PRIZE_SIZE_MESSAGE);

        this.persons = persons;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public Prize getResult(String name) {
        return prizes.get(ladder.lineDown(persons.get(name)));
    }

    public LadderPrizes getAllResult() {
        LadderPrizes ladderPrizes = new LadderPrizes();
        persons.forEach(person -> ladderPrizes.add(new LadderPrize(person, getResult(person.getName()))));
        return ladderPrizes;
    }

    @Override
    public String print() {
        return persons.print() + System.lineSeparator() +
                ladder.print() + System.lineSeparator() +
                prizes.print();
    }
}
