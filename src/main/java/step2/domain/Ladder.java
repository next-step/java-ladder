package step2.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int countOfPerson, LineStrategy lineStrategy) {
        createLadder(height, countOfPerson, lineStrategy);
    }

    public Result play(Users users) {
        Map<Integer, Integer> result = IntStream.range(0, users.size())
            .boxed()
            .collect(Collectors.toMap(Function.identity(), this::getPrize));
        return new Result(result);
    }

    public List<Line> value() {
        return this.ladder;
    }

    private Integer getPrize(Integer col) {
        int height = ladder.size();
        int row = 0;
        while (row != height) {
            Line line = ladder.get(row++);
            col = line.next(col);
        }
        return col;
    }

    private void createLadder(int height, int countOfPerson, LineStrategy lineStrategy) {
        IntStream.range(0, height)
            .forEach(ignore -> ladder.add(new Line(countOfPerson, lineStrategy)));
    }
}
