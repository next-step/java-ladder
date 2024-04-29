package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Location {

    private List<Integer> location;

    public Location(int size) {
        IntStream.range(0, size).forEach(location::add);
    }

    public void swap(List<Boolean> line) {
        IntStream.range(1, line.size())
                .filter(i -> line.get(i))
                .forEach(i -> Collections.swap(location, i, i - 1));
    }

    public void move(Location changeLocation) {
        for (int i = 0; i < location.size(); i++) {
            isMove(i, changeLocation);
        }
    }

    private void isMove(int i, Location changeLocation) {
        for (int j = 0; j < location.size(); j++) {
            if (i == changeLocation.get(j))
                Collections.swap(location, i, j);
        }
    }

    private Integer get(int i) {
        return location.get(i);
    }
}
