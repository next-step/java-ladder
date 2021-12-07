package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Line {

    private static final String INVALID_WIDTH_MESSAGE = "width는 짝수일 수 없습니다.";
    private static final Predicate<Integer> widthCondition = width -> width % 2 == 0;

    private final List<LadderPart> ladderParts;

    public Line(int width) {
        if (widthCondition.test(width)) {
            throw new IllegalArgumentException(INVALID_WIDTH_MESSAGE);
        }

        ladderParts = new ArrayList<>();

        PreviousRung previousRung = PreviousRung.of(false);
        for (int i = 0; i < width; i++) {
            LadderPart ladderPart = LadderPartFactory.ladderPart(i, previousRung);
            previousRung = previousRung.changedRung(ladderPart);

            ladderParts.add(ladderPart);
        }
    }

    public int width() {
        return ladderParts.size();
    }

    public List<LadderPart> getLadderParts() {
        return Collections.unmodifiableList(ladderParts);
    }

}
