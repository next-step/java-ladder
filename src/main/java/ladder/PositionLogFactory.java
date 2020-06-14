package ladder;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class PositionLogFactory {

    public PositionLogs createBy(int count) {
        return IntStream.range(0, count)
                .mapToObj(PositionLog::from)
                .collect(collectingAndThen(toList(), PositionLogs::of));
    }
}
