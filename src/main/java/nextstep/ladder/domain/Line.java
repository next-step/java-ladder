package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private static final int MIN_POINT_SIZE = 2;
    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        validateMinPointSize(directions);
        validateLastIndex(directions);

        this.directions = directions;
    }

    private void validateMinPointSize(List<Direction> directions) {
        if(directions.size() < MIN_POINT_SIZE) {
            throw new IllegalArgumentException("한행의 최소 지점 개수는 2입니다.");
        }
    }

    private void validateLastIndex(List<Direction> directions) {
        if ( directions.get( directions.size()-1 ).isRight() ) {
            throw new IllegalArgumentException("한 행의 마지막 지점은 사다리를 가질 수 없습니다.");
        }
    }

    public int size() {
        return directions.size();
    }

    public boolean getPoint(int index) {
        return directions.get(index).isRight();
    }
}
