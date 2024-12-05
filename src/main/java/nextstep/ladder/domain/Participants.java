package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Participants {
    private static final String SPLIT_COMMA = ",";
    private final List<Participant> participants;

    public Participants(String names) {
        this(fromNames(names));
    }

    public Participants(List<Participant> participants) {
        this.participants = new ArrayList<>(participants);
    }

    private static List<Participant> fromNames(String names) {
        List<Participant> participants = new ArrayList<>();
        String[] namesArray = names.split(SPLIT_COMMA);

        IntStream.range(0, namesArray.length).forEach(positionXNum -> {
            participants.add(new Participant(namesArray[positionXNum], positionXNum));
        });
        return participants;
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public String getParticipantResult(String participantStr) {
        return participants.stream()
                .filter(participant -> participantStr.equals(participant.getName()))
                .findFirst().map(Participant::getResult).orElse("");
    }

    public Participant getParticipant(int participantIdx) {
        return participants.get(participantIdx);
    }
}
