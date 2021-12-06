package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final Floors floors;
    private final Participants participants;

    public Ladder(Floors floors, Participants participants) {
        this.floors = floors;
        this.participants = participants;
    }

    public List<Floor> getFloors() {
        return floors.getFloors();
    }

    public String finalResult(LadderResult ladderResult, String participantName) {
        Position initialPosition = participants.initialPosition(new Participant(participantName));
        Position finishedPosition = floors.finishedPosition(initialPosition);

        return ladderResult.result(finishedPosition);
    }

    public List<String> finalResultsOfAll(LadderResult ladderResult) {
        List<String> results = new ArrayList<>();
        participants.getNamesOfParticipants().forEach(name -> results.add(finalResult(ladderResult, name)));

        return results;
    }
}
