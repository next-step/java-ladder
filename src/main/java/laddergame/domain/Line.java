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

    //region [validate]
    private void validate() {
        boolean hasOverlap = IntStream
                    .range(0, points.size())
                    .filter(this::hasNextPoint)
                    .anyMatch(this::hasBothBridge);

        if(hasOverlap){
            throw new IllegalArgumentException("라인의 가로는 옆 라인과 겹칠 수 없습니다");
        }
    }

    private boolean hasNextPoint(int index) {
        return index < points.size() - 1;
    }

    private boolean hasBothBridge(int index) {
        return hasBridge(index) && hasBridge(index + 1);
    }

    private boolean hasBridge(int index) {
        return points.get(index);
    }
    //endregion

    //region [move]
    public int move(int position) {
        if(canMoveLeft(position)){
            position--;
            return position;
        }

        if(canMoveRight(position)){
            position++;
            return position;
        }
        return position;
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && this.hasBridge(position - 1);
    }

    private boolean canMoveRight(int position) {
        return position < size() && this.hasBridge(position);
    }
    //endregion

    public int size(){
        return points.size();
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
