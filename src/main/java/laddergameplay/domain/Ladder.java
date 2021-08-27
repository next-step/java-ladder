package laddergameplay.domain;

import laddergameplay.strategy.LineStrategy;
import laddergameplay.strategy.RandomLineStrategy;

import java.util.*;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();
    private final int widthOfLadder;

    public Ladder(int countOfPeople, int heightOfLadder) {
        this.widthOfLadder = widthOfLadder(countOfPeople);

        for (int i = 0; i < heightOfLadder; i++) {
            LineStrategy lineStrategy = new RandomLineStrategy();
            ladder.add(new Line(widthOfLadder, lineStrategy));
        }
    }

    private int widthOfLadder(int countOfPeople) {
        return countOfPeople - 1;
    }

    public List<Integer> result(){
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < widthOfLadder+1; i++) {
            int result = i;
            for (Line line : ladder) {
                int ir = result;
                int il = result - 1;
                if (ir >= line.getPoints().size()) {
                    if (line.getPoints().get(il)) {
                        result = result - 1;
                    }
                } else if (il < 0) {
                    if (line.getPoints().get(ir)) {
                        result = result + 1;
                    }
                } else {
                    if (line.getPoints().get(ir)) {
                        result = result + 1;
                    } else if (line.getPoints().get(il)) {
                        result = result - 1;
                    }
                }
            }
            resultList.add(result);
        }
        return resultList;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
