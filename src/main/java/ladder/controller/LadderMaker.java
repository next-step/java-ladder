package ladder.controller;

import ladder.domain.Name;
import ladder.domain.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderMaker {

    private final Participants participants;

    private LadderMaker(List<Name> gameParticipants) {
        this.participants = Participants.of(gameParticipants);
    }

    public static LadderMaker of(String name) {
        return new LadderMaker(create(name));
    }

    private static List<Name> create(String name) {
        String[] names = name.split(",");
        return Arrays
                .stream(names)
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public Participants getParticipants() {
        return this.participants;
    }
}
