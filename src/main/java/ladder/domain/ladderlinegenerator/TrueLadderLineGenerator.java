package ladder.domain.ladderlinegenerator;

import ladder.domain.LadderLineGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrueLadderLineGenerator implements LadderLineGenerator {
    @Override
    public List<Boolean> generateLadderLine(int width) {
        return IntStream.range(0, width)
                .mapToObj(i -> true)
                .collect(Collectors.toList());
    }
}
