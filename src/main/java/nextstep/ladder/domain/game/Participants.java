package nextstep.ladder.domain.game;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants implements Iterable<Participant> {
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
        return participantList.indexOf(participant);
    }

    public Stream<Participant> stream() {
        return participantList.stream();
    }

    @Override
    public Iterator<Participant> iterator() {
        return participantList.iterator();
    }
}
