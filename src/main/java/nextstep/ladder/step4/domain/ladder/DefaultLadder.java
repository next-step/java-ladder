package nextstep.ladder.step4.domain.ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import nextstep.ladder.step4.domain.ladder.engine.Ladder;

public class DefaultLadder implements Ladder {

    private final int width;
    private final List<DefaultLine> lines;

    public DefaultLadder(int width, List<DefaultLine> lines) {
        valid(lines);
        this.width = width;
        this.lines = lines;
    }

    @Override
    public LadderResult play() {
        Map<Integer, Integer> result = new HashMap<>();
        final int height = lines.size();
        for (int key = 0; key < width; key++) {
            result.put(key, getTarget(key, height));
        }
        return new LadderResult(result);
    }

    public int size() {
        return lines.size();
    }

    public List<Boolean> lines(int index) {
        return lines.get(index).points();
    }

    private int getTarget(int key, int size) {
        int target = key;
        for (int i = 0; i < size; i++) {
            target = lines.get(i).move(target);
        }
        return target;
    }

    private void valid(List<DefaultLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리의 Line 값이 존재하지 않습니다.");
        }
    }

}
