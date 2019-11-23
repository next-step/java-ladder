package nextstep.ladder.domain.game;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LineResults;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

import java.util.List;

public class Game {

    private final Participants participants;
    private final Lines lines;
    private final LineResults lineResults;

    private Game(Participants participants, Lines lines, LineResults lineResults) {
        this.participants = participants;
        this.lines = lines;
        this.lineResults = lineResults;
    }

    public static Game ready(Participants participants, Lines lines, LineResults lineResults) {
        return new Game(participants, lines, lineResults);
    }

    public GameResults play(String targetParticipantText) {
        List<Participant> targetParticipants = participants.match(targetParticipantText);
        GameResults gameResults = new GameResults();

        for (Participant each : targetParticipants) {
            int finalPosition = lines.move(each.getOrder());
            gameResults.add(new GameResult(each, lineResults.match(finalPosition)));
        }

        return gameResults;
    }

    public List<Participant> getParticipants() {
        return participants.getValue();
    }

    public List<Line> getLines() {
        return lines.getValue();
    }

    public List<String> getLineResults() {
        return lineResults.getValue();
    }
}
