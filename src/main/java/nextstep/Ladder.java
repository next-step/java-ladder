package nextstep;

import java.util.List;

public abstract class Ladder {
    abstract void add(String name);
    abstract void move();
    abstract List<Integer> heights();
    abstract String ladderString(int targetHeight);
    abstract void lineMark(int height, int target);
}
