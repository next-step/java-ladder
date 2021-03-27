package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantList {

    private List<Participant> participants;

    public ParticipantList(String participantString) {
        this.participants = participants(participantString);
    }

    public ParticipantList(List<String> participantList){
        this.participants = participantList.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private List<Participant> participants(String participantString) {
        return Arrays.stream(participantString.split(","))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<String> dto() {
        return this.participants.stream()
                .map(Participant::name)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.participants.size();
    }

    public String flattenedNames() {
        return this.participants.stream()
                .map(participant -> parsedName(participant.name()))
                .collect(Collectors.joining());
    }

    private String parsedName(String name){
        if(name.length()==5){
            return name;
        }
        StringBuilder blackSpace = new StringBuilder();
        for(int count = 0;count<5-name.length();count++){
            blackSpace.append(" ");
        }
        blackSpace.append(name);
        return String.valueOf(blackSpace);
    }
}
