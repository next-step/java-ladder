package nextstep.ladder.auxiliary;

import nextstep.ladder.domain.DefaultLadderLine;
import nextstep.ladder.domain.LadderLines;
import nextstep.ladder.domain.alternative.NextStepLadderLine;

import java.util.function.BiFunction;

public class LadderLinesFactory {
    public static <T> BiFunction<Integer, Integer, LadderLines> getConstructorFunction(Class<T> clazz) {
        if (clazz.isAssignableFrom(NextStepLadderLine.class)) {
            return NextStepLadderLine::new;
        }
        if (clazz.isAssignableFrom(DefaultLadderLine.class)) {
            return DefaultLadderLine::new;
        }
        throw new IllegalArgumentException();
    }
}
