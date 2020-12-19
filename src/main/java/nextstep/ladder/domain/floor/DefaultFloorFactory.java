package nextstep.ladder.domain.floor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultFloorFactory implements FloorFactory {

    @Override
    public Floor generate(int maxLinks) {
        List<Boolean> links = IntStream.range(0, maxLinks)
                .mapToObj(x -> Boolean.TRUE)
                .collect(Collectors.toList());
        return new Floor(links);
    }
}
