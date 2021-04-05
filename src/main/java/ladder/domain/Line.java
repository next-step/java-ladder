package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_WIDTH = 2;
    private static final String MESSAGE_MIN_NUMBER_OF_PLAYERS = "참여자는 2명 이상이어야 합니다.";
    private final int numberOfPlayers;
    private final List<Point> line = new ArrayList<>();

    public Line(int numberOfPlayers) {
        validate(numberOfPlayers);
        this.numberOfPlayers = numberOfPlayers;
        generateLine();
    }

    private void validate(int numberOfPlayers) {
        if (numberOfPlayers < MIN_WIDTH) {
            throw new IllegalArgumentException(MESSAGE_MIN_NUMBER_OF_PLAYERS);
        }
    }

    private void generateLine(){
        Point tmpPoint = Point.randomPoint();
        line.add(tmpPoint);
        for(int i = 1; i < numberOfPlayers-1; i++){
            tmpPoint = Point.next(tmpPoint);
            line.add(tmpPoint);
        }
        tmpPoint = Point.last(tmpPoint);
        line.add(tmpPoint);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < line.size(); i++){
            result.append(line.get(i).toString());
        }
        return result.toString();
    }
}
