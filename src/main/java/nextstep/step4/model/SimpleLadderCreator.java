package nextstep.step4.model;

import nextstep.step4.api.Ladder;
import nextstep.step4.api.LadderCreator;
import nextstep.step4.api.Line;
import nextstep.step4.api.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class SimpleLadderCreator implements LadderCreator {
    public static final int MIN_HEIGHT = 1;

    private final LineCreator lineCreator;

    public SimpleLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int height, int countOfPerson) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("최소 높이는 " + MIN_HEIGHT + " 입니다");
        }

        List<Line> lines = new ArrayList<>();

        for (int i = 1; i <= height; i++) {
            lines.add(lineCreator.create(countOfPerson));
        }

        return new SimpleLadder(countOfPerson, lines);
    }
}
