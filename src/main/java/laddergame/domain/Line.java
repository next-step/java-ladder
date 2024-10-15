package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int playerCount) {
        initialize(playerCount - 1);
    }

    private void initialize(int width) {
        for (int i = 0; i < width; i++) {
            points.add(Boolean.FALSE);
        }
    }

    public int size(){
        return points.size();
    }
}
