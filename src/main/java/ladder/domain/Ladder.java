package ladder.domain;

import ladder.core.LadderLine;
import ladder.core.LadderLineGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.dto.response.LadderResult;
import ladder.factory.GeneratorFactoryBean;

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
        return Stream.generate(() -> InnerLazyClass.LINE_GENERATOR.generate(pointSize))
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
        Map<Player, Prize> resultMap = IntStream.range(0, players.size())
                .boxed()
                .collect(Collectors.toMap(
                        players::get,
                        index -> prizes.get(this.move(index))
                ));
        return new LadderResult(this, resultMap);
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return ladderLines.iterator();
    }

    private static class InnerLazyClass {
        private static final LadderLineGenerator LINE_GENERATOR = GeneratorFactoryBean.getInstance().ladderLineGenerator();
    }
}
