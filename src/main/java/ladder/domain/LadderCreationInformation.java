package ladder.domain;

import ladder.exception.PeopleNullPointerException;

import java.util.Objects;

public final class LadderCreationInformation {

    private final People people;
    private final LadderHeight ladderHeight;

    private LadderCreationInformation(People people, LadderHeight ladderHeight) {
        validatePeopleNull(people);
        this.people = people;
        this.ladderHeight = ladderHeight;
    }

    private final void validatePeopleNull(People people) {
        if(Objects.isNull(people)) {
            throw new PeopleNullPointerException();
        }
    }

    public static final LadderCreationInformation from(People people, LadderHeight ladderHeight) {
        return new LadderCreationInformation(people, ladderHeight);
    }
}
