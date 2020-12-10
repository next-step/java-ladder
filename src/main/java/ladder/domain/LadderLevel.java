package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
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
        new ConsecutivelyStepChecker(items).check((levelItems, idx) -> {
            throw new IllegalArgumentException("step 은 연속해서 구성할 수 없습니다");
        });
    }

    private void shouldBar(LevelItem first, LevelItem last) {
        if (!first.isBar() || !last.isBar()) throw new IllegalArgumentException("처음과 끝은 Bar 로 구성해야 합니다.");
    }

    @Override
    public String toString() {
        String str = IntStream.range(0, items.size())
                .mapToObj(idx -> items.get(idx).toString())
                .collect(Collectors.joining());
        return "      " + str;
    }

    public int move(int startPos) {
        shouldBeBarPos(startPos);

        int left = startPos - 1;
        int right = startPos + 1;

        if( isStep(left) ) return left - 1;
        if( isStep(right) ) return right + 1;
        return startPos;
    }

    private boolean isStep(int itemIdx) {
        if(itemIdx < 0 ) return false;
        if(itemIdx >= items.size()) return false;
        return items.get(itemIdx).isStep();
    }

    private void shouldBeBarPos(int startPos) {
        if( startPos % 2 == 1 ) throw new IllegalArgumentException("bar 위치에서만 이동을 시작할 수 있습니다");
    }
}
