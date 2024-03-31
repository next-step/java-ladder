package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGameResult {

    private final Map<Integer, String> prizeMap;
    private final List<ParticipantPosition> participantPositions;


    public LadderGameResult(List<String> prizes, List<ParticipantPosition> participantPositions) {
        this.participantPositions = participantPositions;
        this.prizeMap = new HashMap<>();
        IntStream.range(0, prizes.size())
                .forEach(position -> prizeMap.put(position, prizes.get(position)));
    }

    public String getPrize(String name) {
        int position = getParticipantPosition(name).getPosition();
        return prizeMap.get(position);
    }

    public ParticipantPosition getParticipantPosition(String name) {
        return this.participantPositions.stream()
                .filter(position -> position.getParticipantName().equals(name))
                .findAny()
                .orElseThrow();
    }

    public List<ParticipantPosition> getParticipantPositions() {
        return this.participantPositions;
    }

}
