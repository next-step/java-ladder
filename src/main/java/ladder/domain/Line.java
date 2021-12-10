package ladder.domain;

import ladder.util.function.Function;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final String INVALID_WIDTH_MESSAGE = "width는 짝수일 수 없습니다.";

    private final List<LadderPart> ladderParts;

    public Line(int width) {
        if (Function.EVEN_NUMBER.test(width)) {
            throw new IllegalArgumentException(INVALID_WIDTH_MESSAGE);
        }

        LadderPartFactory.initIsPreviousRungSet();
        ladderParts = IntStream.range(0, width)
                .mapToObj(LadderPartFactory::ladderPart)
                .collect(Collectors.toList());
    }

    public int width() {
        return ladderParts.size();
    }

    public List<LadderPart> getLadderParts() {
        return Collections.unmodifiableList(ladderParts);
    }

}
