package ladder.domain;

public class LadderGame {
    private final Ladder ladder;
    private final Points resultParticipants;

    public LadderGame(Ladder ladder, Points participants) {
        this.ladder = ladder;
        this.resultParticipants = gameResult(participants);
    }

    public Points filteredResultByName(String name) {
        return resultParticipants.filteredPoints(name);
    }

    private Points gameResult(Points participants) {
        Points resultParticipants = participants;
        for (Line line: this.ladder.getLines()) {
            resultParticipants = this.moveByLine(resultParticipants, line);
        }
        return resultParticipants;
    }

    private Points moveByLine(Points points, Line line) {
        MoveStrategy moveStrategy = new MoveByLine(line);
        return points.movedPoints(moveStrategy);
    }
}
