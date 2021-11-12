package domain;

import java.util.Arrays;

public class ParticipantFactory {
    private final String[] rawInput;

    public ParticipantFactory(String[] rawInput) {
        this.rawInput = rawInput;
    }

    public Participants produceParticipants() {
        Participants participants = new Participants();
        Arrays.stream(rawInput)
                .forEach(name -> participants.add(new Participant(name)));

        return participants;
    }
}
