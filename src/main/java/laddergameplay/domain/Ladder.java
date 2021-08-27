package laddergameplay.domain;

import laddergame.exception.CustomException;
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

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public WinningResult makeWinningResult(People people, Results results) {
        if (results.getResults().size() != people.getPeople().size()) {
            throw new CustomException("실행 결과의 개수를 잘못 입력 하였습니다.");
        }

        List<Integer> winningResultList = result();

        Map<Person, Result> winningResultMap = new LinkedHashMap<>();

        for (int i = 0; i < winningResultList.size(); i++) {
            Person person = people.getPeople().get(i);
            Result result = results.getResults().get(winningResultList.get(i));
            winningResultMap.put(person, result);
        }

        return new WinningResult(winningResultMap);
    }

    private List<Integer> result(){
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
}
