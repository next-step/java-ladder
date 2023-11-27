package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningPrize {

    private final Map<Integer, String> prizes;

    public WinningPrize(List<String> prizes) {
        this.prizes = IntStream.range(0, prizes.size())
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                prizes::get,
                (oldVal, newVal) -> newVal,
                LinkedHashMap::new
            ));
    }

    public String prize(int position) {
        return prizes.get(position);
    }

    @Override
    public String toString() {
        return prizes.values().stream()
            .map(val ->String.format("%-6s", val))
            .collect(Collectors.joining());
    }
}
