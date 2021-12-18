package nextstep.ladder.step4.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.step4.domain.ladder.engine.Ladder;
import nextstep.ladder.step4.domain.ladder.engine.LadderGenerator;
import nextstep.ladder.step4.domain.ladder.strategy.RandomLineStrategy;

public class DefaultLadderGenerator implements LadderGenerator {

    private final int width;
    private final Height height;

    public DefaultLadderGenerator(int width, Height height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Ladder generate() {
        DefaultLineGenerator defaultLineGenerator = new DefaultLineGenerator(new RandomLineStrategy());

        List<DefaultLine> ladder = new ArrayList<>();
        final int height = this.height.height();
        for (int i = 0; i < height; i++) {
            ladder.add(defaultLineGenerator.generate(this.width));
        }

        return new DefaultLadder(this.width, ladder);
    }

}
