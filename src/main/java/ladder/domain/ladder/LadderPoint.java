package ladder.domain.ladder;

import ladder.domain.player.Person;

public class LadderPoint {

    private Person person;
    private boolean rightValue;

    public LadderPoint(Person person, boolean rightValue) {
        this.person = person;
        this.rightValue = rightValue;
    }

    public boolean isRightValue() {
        return this.rightValue;
    }

    @Override
    public String toString() {
        if (this.rightValue) {
            return "-----|";
        }

        return "     |";
    }

    public boolean hasPerson(Person person) {
        return this.person.equals(person);
    }

    public Person getPerson() {
        return person;
    }
}
