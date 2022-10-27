package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladders {

    private final List<Ladder> ladders = new ArrayList<>();

    public Ladders(final ParticipantNames participantNames, final int height) {
        for (ParticipantName name : participantNames.getParticipantNames()) {
            ladders.add(Ladder.of(name, height));
        }
    }

    public static Ladders of(ParticipantNames participantNames, final int height) {
        return new Ladders(participantNames, height);
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int countLadder(){
        return ladders.size();
    }

    public ParticipantNames getParticipantNames(){
        List<ParticipantName> participantNames = ladders.stream()
                .map(ladder -> ladder.getParticipantName())
                .collect(Collectors.toList());

        return ParticipantNames.from(participantNames);
    }
}
