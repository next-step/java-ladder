package nextstep;

import java.util.List;

public interface Ladder {
    void add(String name);
    void move();
    List<Integer> heights();
}
