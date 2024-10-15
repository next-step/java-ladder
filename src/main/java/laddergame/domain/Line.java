package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;
    private LadderLineStatusGenerator generator;

    public Line(int playerCount, LadderLineStatusGenerator generator) {
        this.generator = generator;
        initialize(playerCount - 1);
        generateLine(generator);
    }

    public Line(List<Boolean> points) {
        this.points = points;
        validate();
    }

    private void initialize(int width) {
        this.points = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            points.add(Boolean.FALSE);
        }
    }

    private void validate() {
        boolean hasOverlap = IntStream
                    .range(0, points.size())
                    .anyMatch(this::hasBothHorizontalLine);

        if(hasOverlap){
            throw new IllegalArgumentException("라인의 가로는 옆 라인과 겹칠 수 없습니다");
        }
    }

    private boolean hasBothHorizontalLine(int index) {
        return hasHorizontalLine(index) && hasHorizontalLine(index + 1);
    }

    private void generateLine(LadderLineStatusGenerator generator){
        IntStream.range(0, points.size())
                .filter(this::canAddHorizontalLine)
                .forEach((index) -> points.set(index, generator.generate()));
    }

    private boolean canAddHorizontalLine(int index) {
        return index == 0 || hasNotHorizontalLine(index - 1);
    }

    private boolean hasHorizontalLine(int index) {
        return points.get(index);
    }

    private boolean hasNotHorizontalLine(int index) {
        return !hasHorizontalLine(index);
    }

    public int size(){
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
