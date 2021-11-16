package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final String[] rawInput;
    private final List<Participant> participantList;

    public Participants(String[] rawInput) {
        this.rawInput = rawInput;
        participantList = new ArrayList<>();
    }

    public int size() {
        return participantList.size();
    }

    public List<String> getNamesOfParticipants() {
        return participantList.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public void produceParticipants() {
        Arrays.stream(rawInput)
                .forEach(name -> participantList.add(new Participant(name)));
    }
}
