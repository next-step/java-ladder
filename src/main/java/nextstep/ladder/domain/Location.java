package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Location {

    private List<Integer> location = new ArrayList<>();

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
            if (isMove(i, changeLocation)) i++;
        }
    }

    private boolean isMove(int i, Location changeLocation) {
        for (int j = 0; j < location.size(); j++) {
            if (i != j && i == changeLocation.getter(j)) {
                Collections.swap(location, i, j);
                return true;
            }
        }
        return false;
    }

    public int getter(int i) {
        return location.get(i);
    }

    public int size() {
        return location.size();
    }

    public int indexOf(int value) {
        return location.indexOf(value);
    }
}
