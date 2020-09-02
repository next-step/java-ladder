package nextstep.mission.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Participants {

    private List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public Participant get(int position) {
        return participants.get(position);
    }

    public int getPosition(String name) {
        return IntStream.range(0, participants.size())
                .filter(index -> participants.get(index).equals(new Participant(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 하는 Participant이 존재하지 않습니다."));
    }

    public boolean contains(String name) {
        return participants.contains(new Participant(name));
    }
}
