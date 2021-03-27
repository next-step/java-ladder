package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantList {

    private List<Participant> participants;

    public ParticipantList(String participantString){
        this.participants = participants(participantString);
    }

    private List<Participant> participants(String participantString){
        return Arrays.stream(participantString.split(","))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<String> dto(){
        return this.participants.stream()
                .map(Participant::name)
                .collect(Collectors.toList());
    }
}
