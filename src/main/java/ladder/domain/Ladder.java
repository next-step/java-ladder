package ladder.domain;

import ladder.domain.line.LadderLine;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.dto.response.LadderResult;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder implements Iterable<LadderLine> {
    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder generate(final int lineSize, final int pointSize) {
        return Stream.generate(() -> LadderLine.generate(pointSize))
                .limit(lineSize)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), Ladder::new
                ));
    }

    public int move(int index) {
        for (LadderLine iLadderLine : ladderLines) {
            index = iLadderLine.move(index);
        }
        return index;
    }

    public LadderResult result(Players players, List<Prize> prizes) {
        Map<Player, Prize> data = IntStream.range(0, players.size())
                .boxed()
                .collect(Collectors.toMap(
                        players::get,
                        index -> prizes.get(this.move(index))
                ));
        return new LadderResult(this, data);
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return ladderLines.iterator();
    }
}
