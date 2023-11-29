package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningPrize {

    private final Map<Integer, String> prizesByPosition;

    public WinningPrize(List<String> prizesByPosition) {
        this.prizesByPosition = IntStream.range(0, prizesByPosition.size())
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                prizesByPosition::get,
                (oldVal, newVal) -> newVal,
                LinkedHashMap::new
            ));
    }

    public String prize(int position) {
        return prizesByPosition.get(position);
    }

    @Override
    public String toString() {
        return prizesByPosition.values().stream()
            .map(val ->String.format("%-6s", val))
            .collect(Collectors.joining());
    }
}
