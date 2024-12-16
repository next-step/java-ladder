package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.laddergame.position.Positions;
import nextstep.ladder.domain.laddergame.position.ResultPosition;
import nextstep.ladder.domain.line.Line;

import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {

    public ResultPosition play(Ladder ladder) {
        ResultPosition resultPosition = new ResultPosition();

        IntStream.range(0, ladder.getPlayers().size())
                 .forEach(i -> {
                     resultPosition.add(i, getLastPosition(ladder.getLines(), i));
                 });

        return resultPosition;
    }

    private int getLastPosition(List<Line> lines, int playerPosition) {
        return new Positions().add(lines, playerPosition).getLastPosition();
    }
}
