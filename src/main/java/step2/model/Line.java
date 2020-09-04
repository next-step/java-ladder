package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> rungs = new ArrayList<>();

    public void drawNewLine(int countOfPerson, DrawStrategy strategy) {
        rungs = Stream
                .generate(() -> draw(strategy))
                .limit(countOfPerson - 1)
                .collect(Collectors.toList());
    }

    public boolean draw(DrawStrategy strategy) {
        if (strategy.draw()) {
            return true;
        }
        return false;
    }

    public String printRungs() {
        return rungs.toString();
    }
}
