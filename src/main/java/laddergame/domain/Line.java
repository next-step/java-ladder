package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int playerCount, LadderLineGenerator generator) {
        this(generator.generate(playerCount - 1));
    }

    public Line(List<Boolean> points) {
        this.points = points;
        validate();
    }

    private void validate() {
        boolean hasOverlap = IntStream
                    .range(0, points.size())
                    .filter(this::isNotLastLine)
                    .anyMatch(this::hasBothHorizontalLine);

        if(hasOverlap){
            throw new IllegalArgumentException("라인의 가로는 옆 라인과 겹칠 수 없습니다");
        }
    }

    private boolean isNotLastLine(int index) {
        return points.size() - 1 > index;
    }

    private boolean hasBothHorizontalLine(int index) {
        return hasHorizontalLine(index) && hasHorizontalLine(index + 1);
    }

    private boolean hasHorizontalLine(int index) {
        return points.get(index);
    }

    public int size(){
        return points.size();
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
