package step2;

import step2.strategy.MakeLineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, MakeLineStrategy strategy) {

    }


    private int getLineSize(int countOfPerson) {
        return countOfPerson - 1;
    }
}
