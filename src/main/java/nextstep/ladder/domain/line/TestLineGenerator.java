package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestLineGenerator implements LineGenerator {

    private static final int START = 0;

    @Override
    public List<Boolean> generator(int countOfPerson) {
        return IntStream.range(START, countOfPerson)
                .mapToObj(i -> true)
                .collect(Collectors.toList());
    }
}
