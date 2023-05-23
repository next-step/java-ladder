package nextstep.ladder.domain;

import nextstep.ladder.util.CombinationUtil;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line (int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("사람은 2명 이상이어야 합니다");
        }
        this.points = CombinationUtil.generateNonAdjacentBooleanCombination(countOfPerson - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
