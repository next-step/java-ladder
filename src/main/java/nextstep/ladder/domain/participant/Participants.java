package nextstep.ladder.domain.participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<Participant> participantList;

    public Participants(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public static Participants of(String[] participants) {
        List<Participant> participantList = new ArrayList<>();
        Arrays.stream(participants)
                .forEach(participant -> participantList.add(new Participant(participant, participantList.size())));
        return new Participants(participantList);
    }

    public void insertMyResult(String[] results) {
        participantList.stream()
                .forEach(participant -> participant.insertResult(results));
    }

    public Participant findByName(String name) {
        return participantList.stream()
                .filter(participant -> participant.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can not find name"));
    }

    public int getParticipantsNumber() {
        return participantList.size();
    }

    public final List<Participant> getParticipantList() {
        return Collections.unmodifiableList(participantList);
    }
}
