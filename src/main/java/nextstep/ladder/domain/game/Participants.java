package nextstep.ladder.domain.game;

import nextstep.ladder.domain.game.exception.ParticipantNotFoundException;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants implements Iterable<Participant> {
    private static final String PARTICIPANT_NOT_FOUND_ERROR_MESSAGE =
            "알 수 없는 참가자 이름입니다";
    private static final int NO_EXIST_INDEX = -1;

    private List<Participant> participantList;

    public Participants(List<String> names) {
        this.participantList = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return participantList.size();
    }

    public Participant get(int index) {
        return participantList.get(index);
    }

    public int indexOf(Participant participant) {
        int index = participantList.indexOf(participant);
        if (index == NO_EXIST_INDEX) {
            throw new ParticipantNotFoundException(
                    PARTICIPANT_NOT_FOUND_ERROR_MESSAGE);
        }
        return index;
    }

    public Stream<Participant> stream() {
        return participantList.stream();
    }

    @Override
    public Iterator<Participant> iterator() {
        return participantList.iterator();
    }
}
