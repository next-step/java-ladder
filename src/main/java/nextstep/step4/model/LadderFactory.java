package nextstep.step4.model;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    public static final int MIN_HEIGHT = 1;

    private LadderFactory() {
    }

    public static Ladder of(int height, int countOfPerson) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("최소 높이는 " + MIN_HEIGHT + " 입니다");
        }

        List<Line> lines = new ArrayList<>();

        for (int i = 1; i <= height; i++) {
            lines.add(LineFactory.from(countOfPerson));
        }

        return new Ladder(countOfPerson, lines);
    }
}
