package ladder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLevel {

    private List<LevelItem> items;

    public static LadderLevel autoGenerate(int size) {
        return new LadderLevel(LadderLevelGenerator.auto().generate(size));
    }

    public LadderLevel(List<LevelItem> items) {
        shouldBar(items.get(0), items.get(items.size() - 1));
        shouldNotConsecutivelyStep(items);
        this.items = items;
    }

    private void shouldNotConsecutivelyStep(List<LevelItem> items) {
        IntStream.range(0, items.size())
                .filter(idx -> items.get(idx).isStep())
                .forEach(idx -> {
                    if( nextStep(items, idx).isPresent() )
                        throw new IllegalArgumentException("step 은 연속해서 구성할 수 없습니다");
                });
    }

    private void shouldBar(LevelItem first, LevelItem last) {
        if (!first.isBar() || !last.isBar()) throw new IllegalArgumentException("처음과 끝은 Bar 로 구성해야 합니다.");
    }

    private Optional<LevelItem> nextStep(List<LevelItem> items, int idx) {
        int nextStepIdx = idx + 2;
        if (items.size() > nextStepIdx
                && items.get(nextStepIdx).isStep()) {
            return Optional.ofNullable(items.get(nextStepIdx));
        }
        return Optional.ofNullable(null);
    }

    @Override
    public String toString() {
        String str = IntStream.range(0, items.size())
                .mapToObj(idx -> items.get(idx).toString())
                .collect(Collectors.joining());
        return "      " + str;
    }
}
