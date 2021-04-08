package ladder.domain;

import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final String MESSAGE_MIN_HEIGHT = "사다리 높이는 1이상이어야 합니다.";
    private final Lines lines = new Lines();
    private final int height;

    public Ladder(int numberOfPlayers, int height) {
        validate(height);
        this.height = height;
        generateLadder(numberOfPlayers, height);
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MESSAGE_MIN_HEIGHT);
        }
    }

    public void generateLadder(int numberOfPlayers, int height) {
        for(int i=0; i<height; i++){
            lines.add(new Line(numberOfPlayers));
        }
    }

    public List<Line> lines(){
        return lines.lines();
    }
}
