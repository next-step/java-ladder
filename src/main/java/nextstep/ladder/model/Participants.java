package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Participants {

    private static final String DEFAULT_DELIMITER = ",";
    private static final int MINIMUM_COUNT = 2;

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        Assert.notEmpty(participants, "names must not be empty");
        validateSize(participants);
        this.participants = new ArrayList<>(participants);
    }

    public static Participants from(String namesString) {
        Assert.hasText(namesString, "names must not be blank");
        return new Participants(Arrays.stream(namesString.split(DEFAULT_DELIMITER))
                .map(Participant::from)
                .collect(Collectors.toList())
        );
    }

    public int numberOfGaps() {
        return participants.size() - 1;
    }

    public List<Participant> list() {
        return Collections.unmodifiableList(participants);
    }

    private void validateSize(List<Participant> participants) {
        if (participants.size() < MINIMUM_COUNT) {
            throw new IllegalArgumentException(String.format("participants count(%d) must be at least %d", participants.size(), MINIMUM_COUNT));
        }
    }
}
