package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Ladder {
    private final static int INITIAL = 0;
    private final List<Line> lines;

    private Ladder(int height, int countOfPerson) {
        lines = new ArrayList<>();
        IntStream.range(INITIAL, height)
                .forEachOrdered(number -> lines.add(Line.of(countOfPerson)));
    }

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder of(int height, int numberOfUser) {
        return new Ladder(height, numberOfUser);
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<String, String> move(List<String> names, List<String> ladderResult) {
        Map<String, String> result = new LinkedHashMap<>();
        names.stream().forEachOrdered(name -> result.put(name, " "));
        for (String name : names) {
            int index = moveMove(names.indexOf(name));
            result.put(name, ladderResult.get(index));
            //System.out.println(name + ": " + result.get(name));
        }
        return result;
    }

    public int moveMove(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

}
