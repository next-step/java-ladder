package nextstep.ladder.participant;

import nextstep.ladder.view.OutPutViewUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int findIndexByName(String name) {
        Participant participant = new Participant(name);
        int indexOf = participants.indexOf(participant);
        if (indexOf == -1)
            throw new IllegalArgumentException("존재하지 않는 이름입니다");

        return indexOf;
    }

    public int size() {
        return participants.size();
    }

    public String getParticipantsName() {
        return participants.stream()
                .map(Participant::getName)
                .map(OutPutViewUtils::appendPaddingBeforeValue)
                .collect(Collectors.joining());
    }

    public Participant get(int index) {
        return participants.get(index);
    }
}
