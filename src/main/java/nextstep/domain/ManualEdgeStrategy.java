package nextstep.domain;

import java.util.List;

/**
 * 수동으로 라인 잡아줄 경우
 */
public class ManualEdgeStrategy implements EdgeStrategy {
    private final List<Boolean> statues;

    public ManualEdgeStrategy(List<Boolean> statues) {
        this.statues = statues;
    }

    @Override
    public boolean generate(int index, boolean connected) {
        if (index >= statues.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return statues.get(index);
    }
}
