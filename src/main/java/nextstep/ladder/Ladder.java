package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String LADDER_DELIMITER = "\n";

    private List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        this.lines = createLines(countOfPerson, height);
    }

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    private List<Line> createLines(int countOfPerson, int height) {
        List<Line> nLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            nLines.add(new Line(countOfPerson));
        }

        return nLines;
    }

    public int move(int position) {
        int index = position;
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public String getLadderForPrint(String trueSymbol, String falseSymbol) {
        return lines.stream()
                .map(line -> line.getLineForPrint(trueSymbol, falseSymbol))
                .collect(Collectors.joining(LADDER_DELIMITER));
    }

    //todo lines.get(0).getCrossSize()
    public Map<Integer, Integer> getAllResult() {
        return IntStream.range(0, lines.get(0).getCrossSize())
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> move(i)));
    }

}
