package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    List<Boolean> points = new ArrayList<>();
    int height;

    public Line(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
