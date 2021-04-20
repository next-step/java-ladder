package ladder.domain;

import common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Participants {

    private static final String NAME_DELIMITER = ",";
    public static final String ALL_PARTICIPANTS = "all";
    public static final int MIN_ENTRANCE_NUMBER = 0;

    private final List<Participant> participants;

    public Participants(String participantNames) {
        this(generateParticipants(participantNames));
    }

    public Participants(List<Participant> participants) {
        validateParticipants(participants);
        this.participants = participants;
    }

    private void validateParticipants(List<Participant> participants) {
        if (participants == null || participants.size() == 0) {
            throw new IllegalArgumentException("참가자 정보를 입력해 주세요.");
        }
    }

    private static List<Participant> generateParticipants(String participantNames) {
        validateParticipantNames(participantNames);
        List<Participant> participants = Arrays.stream(participantNames.split(NAME_DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toList());
        validateDuplicate(participants);
        return participants;
    }

    private static void validateParticipantNames(String participantNames) {
        if (StringUtils.isBlank(participantNames)) {
            throw new IllegalArgumentException("참가자 이름을 입력해 주세요.");
        }
        if (participantNames.contains(ALL_PARTICIPANTS)) {
            throw new IllegalArgumentException(ALL_PARTICIPANTS + " 은 사용할 수 없는 이름입니다.");
        }
    }

    private static void validateDuplicate(List<Participant> participants) {
        int count = participants.size();
        int distinctCount = (int) participants.stream()
                .distinct()
                .count();
        if (count > distinctCount) {
            throw new IllegalArgumentException("중복된 참가자가 존재합니다. 참가자명을 다시 입력해 주세요.");
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int getCount() {
        return participants.size();
    }

    public int getEntranceNumber(String name) {
        return participants.indexOf(findParticipant(name));
    }

    private Participant findParticipant(String name) {
        return participants.stream()
                .filter(participant -> participant.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(name + " 은 존재하지 않는 참가자 입니다."))
                ;
    }
}
