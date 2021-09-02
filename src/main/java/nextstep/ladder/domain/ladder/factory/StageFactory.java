package nextstep.ladder.domain.ladder.factory;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Stage;
import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.strategy.HorizontalLinesGenerateStrategy;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

import java.util.ArrayList;
import java.util.List;

public class StageFactory {

    private StageFactory() {
    }

    public static Stage generateWith(int height, Participants participants, HorizontalLinesGenerateStrategy strategy) {
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.get(i);
            Ladder ladder = LadderFactory.generateWith(height, participant, strategy);
            ladders.add(ladder);
        }
        removeLastLadderHorizontalLines(ladders);
        return new Stage(ladders);
    }

    private static void removeLastLadderHorizontalLines(List<Ladder> ladders) {
        int size = ladders.size();
        int lastIndex = size - 1;
        Ladder ladder = ladders.get(lastIndex);

        ladder.getHorizontalLines()
                .forEach(HorizontalLine::remove);
    }
}
