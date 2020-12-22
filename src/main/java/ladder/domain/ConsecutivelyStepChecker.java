package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class ConsecutivelyStepChecker {

    /**
     * 연속되는 step 이 존재하는지 확인해서 발생하면 action 을 실행합니다.
     *
     * action 은 LadderLevel 의 전체 items 와 확인된 item 의 index 를 인자로 받습니다.
     * @param action
     */
    public static void check(List<LadderItem> items, BiConsumer<List<LadderItem>, Integer> action) {
        IntStream.range(0, items.size())
                .filter(idx -> items.get(idx).isStep())
                .forEach(idx -> {
                    nextStep(items, idx).ifPresent(item -> {
                        action.accept(items, idx);
                    });
                });
    }

    private static Optional<LadderItem> nextStep(List<LadderItem> items, int idx) {
        int nextStepIdx = idx + 2;
        if (items.size() > nextStepIdx
                && items.get(nextStepIdx).isStep()) {
            return Optional.ofNullable(items.get(nextStepIdx));
        }
        return Optional.ofNullable(null);
    }

}
