package nextstep.refactoring;

import nextstep.ladder.strategy.BooleanGenerator;

/**
 * 여러 position을 통해 하나의 선(가로라인)의 상태를 유지
 * 현재 위치에서 다음 위치에 대한 응답
 */
public class Line {
    private final Positions positions;

    public Line(int countOfPerson, BooleanGenerator booleanGenerator) {
        this.positions = new Positions(countOfPerson, booleanGenerator);
    }

    public int move(int index) {
        return positions.move(index);
    }
}
