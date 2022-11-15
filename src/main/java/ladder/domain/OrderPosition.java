package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderPosition {

    public List<Map.Entry<Position, Position>> order(List<Position> userPositions, List<Position> resultPositions) {
        return IntStream.range(0, userPositions.size())
                .mapToObj((idx) -> Map.entry(userPositions.get(idx), resultPositions.get(idx)))
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
    }
}
