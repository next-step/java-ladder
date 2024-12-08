package nextstep.laddergame.service;

import nextstep.laddergame.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {
    private final Random random = new Random();

    @Override
    public Line generate(int lineCount) {
        List<Boolean> crosses;
        do {
            crosses = IntStream.range(0, lineCount)
                    .collect(ArrayList::new, (tempCrosses, index) -> {
                        if (!tempCrosses.isEmpty() && (isLeftAlreadySet(tempCrosses, index))) {
                            tempCrosses.add(false);
                            return;
                        }
                        tempCrosses.add(random.nextBoolean());
                    }, ArrayList::addAll);
        } while (isAllNonSet(crosses));

        return new Line(crosses);
    }

    private boolean isLeftAlreadySet(List<Boolean> tempCrosses, int currentIndex) {
        return tempCrosses.get(currentIndex - 1);
    }
}
