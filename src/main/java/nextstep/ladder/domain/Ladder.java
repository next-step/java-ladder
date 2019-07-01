package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Ladder {
    private List<Line> lines;

    private Ladder() {
    }

    public Ladder(int rowSize, int personsSize) {
        if (rowSize < 1) {
            throw new IllegalArgumentException("사다리 높이는 1이상이여야 합니다.");
        }

        this.lines = IntStream.rangeClosed(1, rowSize)
                .boxed()
                .map(index -> Line.init(personsSize))
                .collect(Collectors.toList());
    }

    public int size() {
        return this.lines.size();
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
