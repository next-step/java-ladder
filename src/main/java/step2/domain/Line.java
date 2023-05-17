package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> bridges = new ArrayList<>();

    public Line(int height) {
        for (int i = 0; i < height; i++) {
            bridges.add(false);
        }
    }

    public boolean isPresent(int index) {
        return bridges.get(index);
    }

    public void addBridge(int index) {
        bridges.set(index, true);
    }

}
