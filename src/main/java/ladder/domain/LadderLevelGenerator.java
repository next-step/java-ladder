package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LadderLevelGenerator {

    List<LadderItem> generate(int size);

    static LadderLevelGenerator auto() {
        return new LadderLevelGenerator() {

            private Random random = new Random();

            @Override
            public List<LadderItem> generate(int size) {
                List<LadderItem> items = IntStream.range(0, size)
                        .mapToObj(idx -> {
                            if (idx % 2 == 0) return LadderItem.Bar;
                            if (random.nextInt(2) == 1) return LadderItem.Step;
                            return LadderItem.Empty;
                        })
                        .collect(Collectors.toList());

                // 연속되는 step 제거
                ConsecutivelyStepChecker.check(items, (levelItems, idx) -> {
                    levelItems.set(idx, LadderItem.Empty);
                });

                return items;
            }
        };
    }
}
