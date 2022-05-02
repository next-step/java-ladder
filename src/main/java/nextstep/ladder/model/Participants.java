package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Participants {

    private static final int MINIMUM_COUNT = 2;

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        Assert.notEmpty(participants, "names must not be empty");
        validateSize(participants);
        this.participants = new ArrayList<>(participants);
    }

    public static Participants from(StringsProvider provider) {
        Assert.notNull(provider, "provider must not be blank");
        return new Participants(provider.strings()
                .stream()
                .map(Participant::from)
                .collect(Collectors.toList())
        );
    }

    public List<Participant> list() {
        return Collections.unmodifiableList(participants);
    }

    public int size() {
        return participants.size();
    }

    boolean isNotExist(Participant participant) {
        return !participants.contains(participant);
    }

    int indexOf(Participant participant) {
        return participants.indexOf(participant);
    }

    public <T> List<T> map(Function<Participant, T> participantFunction) {
        return participants.stream()
                .map(participantFunction)
                .collect(Collectors.toList());
    }

    private void validateSize(List<Participant> participants) {
        if (participants.size() < MINIMUM_COUNT) {
            throw new IllegalArgumentException(String.format("participants count(%d) must be at least %d", participants.size(), MINIMUM_COUNT));
        }
    }

    @Override
    public String toString() {
        return "Participants{" +
                "participants=" + participants +
                '}';
    }
}
