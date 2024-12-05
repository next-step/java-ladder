package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder2 {
    private static final String LADDER_DELIMITER = "\n";

    private List<Line2> lines;

    public Ladder2(int countOfPerson, int height) {
        createLines(countOfPerson, height);
    }

    public Ladder2(List<Line2> lines) {
        this.lines = lines;
    }

    private void createLines(int countOfPerson, int height) {
        lines = new ArrayList<>();

        for(int i = 0; i < height; i++) {
            lines.add(new Line2(countOfPerson));
        }
    }

    public int move(int position) {
        int index = position;
        for(Line2 line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public String getLadderForPrint(String trueSymbol, String falseSymbol) {
        return lines.stream()
                .map(line -> line.getLineForPrint(trueSymbol, falseSymbol))
                .collect(Collectors.joining(LADDER_DELIMITER));
    }

}
