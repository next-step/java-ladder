package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> list = new ArrayList<>();

    public Line(int size) {
        basicLine(size);
        IntStream.range(1, size)
                .filter(i -> !list.get(i - 1))
                .forEach(i -> list.set(i, randomBoolean()));
    }

    private boolean randomBoolean() {
        return new Random().nextBoolean();
    }

    private void basicLine(int k) {
        for (int i = 0; i < k; i++) {
            list.add(false);
        }
    }

    public List<Boolean> getList() {
        return list;
    }
}
