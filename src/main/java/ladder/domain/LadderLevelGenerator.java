package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LadderLevelGenerator {

    List<LevelItem> generate(int size);

    static LadderLevelGenerator auto() {
        return new LadderLevelGenerator() {

            private Random random = new Random();

            @Override
            public List<LevelItem> generate(int size) {
                List<LevelItem> items = IntStream.range(0, size)
                        .mapToObj(idx -> {
                            if (idx % 2 == 0) return LevelItem.bar();
                            if (random.nextInt(2) == 1) return LevelItem.step();
                            return LevelItem.emptyStep();
                        })
                        .collect(Collectors.toList());

                // 연속되는 step 제거
                IntStream.range(0, size)
                        .filter(idx -> items.get(idx).isStep())
                        .forEach(idx -> {
                            nextStep(items, idx).ifPresent(nextStep -> items.set(idx, LevelItem.emptyStep()));
                        });

                return items;
            }

            private Optional<LevelItem> nextStep(List<LevelItem> items, int idx) {
                int nextStepIdx = idx + 2;
                if (items.size() > nextStepIdx
                        && items.get(nextStepIdx).isStep()) {
                    return Optional.ofNullable(items.get(nextStepIdx));
                }
                return Optional.ofNullable(null);
            }
        };
    }
}
