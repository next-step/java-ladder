package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Participant {

    private List<Name> participants;

    public Participant(String... names) {
        validateParticipant(names);
        participants = new ArrayList<>();
        for (String name : names) {
            this.participants.add(new Name(name));
        }
    }

    private void validateParticipant(String[] names){
        if(names.length < 2){
            throw new IllegalArgumentException("사다리 게임 참여자는 2명 이상이어야 합니다.");
        }
    }

    public List<Name> getParticipants() {
        return participants;
    }

    public int getParticipantSize(){
        return participants.size();
    }

    public String getParticipant(int index) {
        Name name = participants.get(index);
        return name.name();
    }
}
