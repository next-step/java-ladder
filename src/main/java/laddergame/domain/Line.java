package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public Line(int playerCount) {
        initialize(playerCount - 1);
    }

    public Line(List<Boolean> points) {
        this.points = points;
        validate();
    }

    public void generateLine(LadderLineStatusGenerator generator){
        for (int index = 0; index < points.size(); index++) {
            addHorizontalLine(generator, index);
        }
    }

    private void addHorizontalLine(LadderLineStatusGenerator generator, int index) {
        if(this.canAddHorizontalLine(index)){
            points.set(index, generator.generate());
        }
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
        return new ArrayList<Boolean>(points);
    }
}
