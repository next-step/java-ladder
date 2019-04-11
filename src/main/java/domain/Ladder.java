package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int depthOfLadder, int numberOfParticipants) {
        for (int i = 0; i < depthOfLadder; i ++) {
            lines.add(new Line(numberOfParticipants));
        }
    }

    public void printLadder(){
        for (Line line : lines) {
            line.printLine();
        }
    }

    public int getNumberOfLines(){
        return lines.size();
    }

    public int move(int currentPosition) {
        for(Line line : lines) {
            int nextPosition = line.move(currentPosition);
            if (nextPosition == currentPosition) {
                continue;
            } else {
                currentPosition = nextPosition;
            }
        }
        return currentPosition;
    }

}
