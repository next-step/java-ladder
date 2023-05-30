package nextstep.step2.domain;

import java.util.List;

public class Participants {

    private static final int MINIMUM_USER_COUNT = 0;

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validate(participants.size());

        this.participants = participants;
    }

    private void validate(int count) {
        if (count <= MINIMUM_USER_COUNT) {
            throw new IllegalArgumentException("사다리 게임의 참여자가 존재하지 않습니다.");
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int count() {
        return participants.size();
    }

    public int position(String name) {
        return participants.indexOf(new Participant(name));
    }
}
