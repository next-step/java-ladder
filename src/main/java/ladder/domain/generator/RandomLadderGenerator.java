package ladder.domain.generator;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;

import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 사다리를 생성합니다.
 */
public class RandomLadderGenerator implements Generator<Ladder> {
    private final int depth;
    private final Generator<LadderLine> ladderLineGenerator;

    /**
     * 랜덤으로 사다리를 생성하는 생성기를 만듭니다.
     *
     * @param depth 이 사다리 생성기가 생성할 사다리의 depth
     * @param theNumberOfColumn 이 사다리 생성기가 생성할 사다리의 컬럼 수
     */
    public RandomLadderGenerator(int depth, int theNumberOfColumn) {
        this.depth = depth;
        this.ladderLineGenerator = new RandomLadderLineGenerator(theNumberOfColumn);
    }

    @Override
    public Ladder make() {
        return this.generateRandomLadder();
    }

    public Ladder generateRandomLadder() {
        List<LadderLine> lines = new ArrayList<>(depth);

        for (int i = 0; i < depth; i++) {
            lines.add(this.ladderLineGenerator.make());
        }

        return Ladder.of(lines);
    }
}