package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    public static final String INPUT_EMPTY_MSG = "참여할 사람은 반드시 입력해야 합니다.";
    public static final String INVALID_PARTICIPANT_COUNT_MSG = "참가자는 2명 이상이어야 합니다.";
    private static final String SPLIT_TEXT = ",";

    private final List<Participant> participants;

    public Participants(String participantTexts) {
        this.participants = initParticipants(participantTexts);
    }

    private List<Participant> initParticipants(String participantTexts) {
        emptyCheck(participantTexts);

        String[] tokens = split(participantTexts);

        List<Participant> participantList = getParticipants(tokens);

        sizeCheck(participantList);

        return participantList;
    }

    private List<Participant> getParticipants(String[] tokens) {
        List<Participant> participantList = new ArrayList<>();
        for (String token : tokens) {
            participantList.add(new Participant(token));
        }
        return participantList;
    }

    private void sizeCheck(List<Participant> participantList) {
        if (participantList.size() < 2) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_COUNT_MSG);
        }
    }

    private String[] split(String participantTexts) {
        return participantTexts.split(SPLIT_TEXT);
    }

    private void emptyCheck(String participantTexts) {
        if (isNullOrEmpty(participantTexts)) {
            throw new IllegalArgumentException(INPUT_EMPTY_MSG);
        }
    }

    private boolean isNullOrEmpty(String participantTexts) {
        return participantTexts == null || participantTexts.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }

    @Override
    public String toString() {
        List<String> collect = this.participants.stream()
                .map(Participant::toString)
                .collect(Collectors.toList());

        return String.join("", collect);
    }
}
