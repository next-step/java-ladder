package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameHelper {

    private final List<String> top;
    private final List<String> bottom;

    public GameHelper(List<String> top, List<String> bottom) {
        this.top = top;
        this.bottom = bottom;

    }

    public Map<String, String> gameResult(Ladder ladder) {
        return IntStream.range(0, top.size())
                .boxed()
                .collect(Collectors.toMap(
                        index -> top.get(index),
                        index -> bottom.get(ladder.finalLine(index)))
                );
    }

    public List<String> getTop() {
        return this.top;
    }

    public List<String> getBottom() {
        return this.bottom;
    }
}
