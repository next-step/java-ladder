package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Floors floors;
    private final Participants participants;

    private final List<LadderLine> ladderLines;

    public Ladder(Floors floors, Participants participants) {
        this.floors = floors;
        this.participants = participants;
        this.ladderLines = new ArrayList<>();
    }

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
        this.floors = null;
        this.participants = null;
    }

    public int finalPoint(int startPoint) {
        int currentPoint = startPoint;
        for (LadderLine ladderLine : ladderLines) {
            currentPoint = ladderLine.move(currentPoint);
        }

        return currentPoint;
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
