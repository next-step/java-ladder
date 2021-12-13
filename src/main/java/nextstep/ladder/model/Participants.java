package nextstep.ladder.model;

import nextstep.ladder.model.value.Participant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {

    private final String FIND_PERSON_ERROR_MSG = "해당 참가자는 존재 하지 않습니다!!!";
    private static final String DELIMITER = ",";

    private static List<Participant> participants;

    private Participants(List<Participant> inputData) {

        this.participants = inputData;
    }

    public static Participants from(String inputData) {

        AtomicInteger position = new AtomicInteger(0);

        return new Participants(
                Arrays.stream(inputData.split(DELIMITER))
                        .map(String::trim)
                        .map(name -> new Participant(name, position.getAndIncrement()))
                        .collect(Collectors.toList()));
    }

    public Participants execute(Ladder ladder) {
        List<Participant> collect = participants.stream()
                .map(participant -> participant.climb(ladder))
                .collect(Collectors.toList());

        return new Participants(collect);
    }

    public Participant findByName(String name) {
        return participants.stream()
                .filter(participant -> participant.isEqualsName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(FIND_PERSON_ERROR_MSG));
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
