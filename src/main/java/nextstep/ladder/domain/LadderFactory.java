package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.generator.GeneratorWidthSize;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class LadderFactory {

    public static Ladder ladder(int height, int width, NonConsecutiveFlagGenerator generator) {
        return new Ladder(width, LadderConverter.convert(height, width, generator));
    }

    private static class LadderConverter {
        private static List<Lines> convert(int height, int width, NonConsecutiveFlagGenerator generator) {
            return toLadder(height, width, generator);
        }

        private static List<Lines> toLadder(int height, int width, NonConsecutiveFlagGenerator generator) {
            return Stream.generate(() -> LinesFactory.lines(generator.create(new GeneratorWidthSize(width - 1))))
                    .limit(height)
                    .collect(Collectors.toList());
        }
    }
}
