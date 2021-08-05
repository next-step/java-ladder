package ladder.domain;

import ladder.core.LadderLine;
import ladder.core.LadderLineGenerator;
import ladder.factory.GeneratorFactoryBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder generate(final int lineSize, final int pointSize) {
        return Stream.generate(() -> InnerLazyClass.GENERATOR.generate(pointSize))
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

    private static class InnerLazyClass {
        private static final LadderLineGenerator GENERATOR = GeneratorFactoryBean.getInstance().ladderLineGenerator();
    }
}
