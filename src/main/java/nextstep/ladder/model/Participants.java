package nextstep.ladder.model;

import nextstep.ladder.model.value.Participant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static List<Participant> participants;

    private Participants(List<Participant> inputData) {

        this.participants = inputData;
    }

    public static Participants from(String inputData) {
        return new Participants(
                Arrays.stream(inputData.split(","))
                        .map(String::trim)
                        .map(Participant::new)
                        .collect(Collectors.toList()));
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
