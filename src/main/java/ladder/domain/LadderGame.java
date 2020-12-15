package ladder.domain;


import ladder.domain.dto.GameResult;
import ladder.domain.dto.Reward;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.LineGenerator;
import ladder.domain.participant.Participants;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private LineGenerator lineGenerator;
    private Reward reward;

    public LadderGame(LineGenerator lineGenerator, Reward reward) {
        this.lineGenerator = lineGenerator;
        this.reward = reward;
    }

    public Ladder makeLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generateLine(width);
            lines.add(line);
        }
        return new Ladder(lines);
    }

    public GameResult play(Participants participants, Ladder ladder) {

        for (int i = 0; i < ladder.sizeHeight(); i++) {
             ladder.movePosition(i, participants);
        }

        return new GameResult(participants.getParticipants(), reward);
    }
}
