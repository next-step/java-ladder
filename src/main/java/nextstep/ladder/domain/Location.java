package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Location {

    private List<Integer> location;

    public Location(List<Boolean> line) {
        IntStream.range(0, line.size()).forEach(location::add);

        IntStream.range(1, line.size())
                .filter(i -> line.get(i))
                .forEach(i -> Collections.swap(location, i, i - 1));
    }


}
