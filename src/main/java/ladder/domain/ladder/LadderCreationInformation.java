package ladder.domain.ladder;

import ladder.domain.participant.People;
import ladder.exception.LadderHeightNullPointerException;
import ladder.exception.PeopleNullPointerException;

import java.util.Objects;

public final class LadderCreationInformation {

    private final People people;
    private final LadderHeight ladderHeight;

    public static final LadderCreationInformation from(People people, LadderHeight ladderHeight) {
        return new LadderCreationInformation(people, ladderHeight);
    }

    private LadderCreationInformation(People people, LadderHeight ladderHeight) {
        validatePeopleNull(people);
        validateLadderHeightNull(ladderHeight);
        this.people = people;
        this.ladderHeight = ladderHeight;
    }

    private final void validatePeopleNull(People people) {
        if (Objects.isNull(people)) {
            throw new PeopleNullPointerException();
        }
    }

    private final void validateLadderHeightNull(LadderHeight ladderHeight) {
        if (Objects.isNull(ladderHeight)) {
            throw new LadderHeightNullPointerException();
        }
    }

    public final int width() {
        return people.countOfPerson();
    }

    public final int height() {
        return ladderHeight.height();
    }
}
