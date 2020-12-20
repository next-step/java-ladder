package nextstep.ladder.domain.floor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultFloorFactory implements FloorFactory {

    @Override
    public Floor generate(int maxLinks) {
        List<Link> links = IntStream.range(0, maxLinks)
                .mapToObj(x -> Link.of(x % 2 == 0))
                .collect(Collectors.toList());
        return new Floor(links);
    }
}
