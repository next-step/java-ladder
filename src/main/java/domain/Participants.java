package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    List<Participant> participantList;

    public Participants() {
        participantList = new ArrayList<>();
    }

    public void add(Participant participant) {
        participantList.add(participant);
    }

    public boolean isSizeEqualTo(int size) {
        return participantList.size() == size;
    }

    public int size() {
        return participantList.size();
    }

    public List<String> provideParticipantsNames() {
        return participantList.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
