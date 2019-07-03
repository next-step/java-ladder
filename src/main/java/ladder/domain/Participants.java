package ladder.domain;

import ladder.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String PARTICIPANTS_DELIMITER = ",";
    private List<Participant> participants;

    public Participants(String participants) {

        if (StringUtils.isBlank(participants)) {
            throw new IllegalArgumentException("참가자명이 유효하지 않습니다.");
        }

        this.participants = StringUtils.split(participants, PARTICIPANTS_DELIMITER)
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<String> getParticipantsName() {

        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public Participant getParticipant(int index) {

        return participants.get(index);
    }

    public int size() {

        return participants.size();
    }
}
