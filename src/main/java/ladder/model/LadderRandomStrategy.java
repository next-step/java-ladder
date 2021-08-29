package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRandomStrategy implements MoveStrategy {

    private Random random;

    public LadderRandomStrategy() {
        this.random = new Random();
    }

    @Override
    public List<Boolean> generate(int size) {
        List<Boolean> result = IntStream.range(0, size)
                .mapToObj((num) -> Boolean.valueOf(false))
                .collect(Collectors.toList());

        for (int idx : makeIndex(size)) {
            result.set(idx, true);
        }
        return result;
    }

    private List<Integer> makeIndex(int size) {
        int maxLength = Math.toIntExact(Math.round((double) size / 2.0));

        return sliceIndex(shuffleTotalIndex(size), size);

    }

    private List<Integer> shuffleTotalIndex(int size) {
        List<Integer> totalIndex = IntStream.range(1, size)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        Collections.shuffle(totalIndex);
        return totalIndex;
    }

    private List<Integer> sliceIndex(List<Integer> totalIndex, int maxLength) {
        int randomNumber = random.nextInt(maxLength);

        List<Integer> index = totalIndex.stream()
                .limit(randomNumber)
                .collect(Collectors.toList());

        Collections.sort(index);

        if (validateOverlapped(index)) {
            return index;
        }
        return sliceIndex(totalIndex, maxLength);
    }

    private boolean validateOverlapped(List<Integer> index) {
        for (int i = 0; i < index.size() - 1; i++) {
            if (index.get(i) + 1 == index.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
