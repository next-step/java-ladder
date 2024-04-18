package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> list = new ArrayList<>();

    public Line(int i) {
        basicLine(i);
        for (int j = 1; j < i; j++) {
            if (!list.get(j - 1))
                list.set(j, randomBoolean());
        }
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
