package nextstep.ladder.domain.line;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {

    private static final int START = 0;
    private static final Random random = new Random();

    @Override
    public List<Boolean> generator(int countOfPerson) {
        return IntStream.range(START, countOfPerson)
                .mapToObj(i -> random.nextBoolean())
                .collect(Collectors.toList());
    }
}
