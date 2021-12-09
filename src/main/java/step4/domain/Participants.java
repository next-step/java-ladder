package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static step4.utils.StringUtil.split;

public class Participants {
    private final List<Participant> participants = new ArrayList<>();

    public Participants(String[] names) {
        for (String name : names) {
            participants.add(Participant.of(name));
        }
    }

    public static Participants of(String names) {
        return new Participants(split(names));
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> participants() {
        return participants;
    }

    public List<String> participantNames() {
        return participants.stream()
                .map(Participant::name)
                .collect(Collectors.toList());
    }

    public int findIndexBy(String name) {
        return participants.indexOf(Participant.of(name));
    }
}
