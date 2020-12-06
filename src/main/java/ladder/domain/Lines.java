package ladder.domain;

import ladder.utils.LadderUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }
    public static Lines of(int countOfPerson){
        return new Lines(createLines(countOfPerson));
    }
    private static List<Line> createLines(int countOfPerson) {
        return  IntStream.range(0, countOfPerson - 1)
                .mapToObj(i -> Line.of(LadderUtil.isLine()))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
