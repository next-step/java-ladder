package nextstep.ladder.line;

import nextstep.ladder.Height;
import nextstep.ladder.Name;
import nextstep.ladder.Names;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    public Lines(Height height, int playerCount) {
        this.lines = createLines(height.getValue(), playerCount);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int size() {
        return lines.size();
    }

    public Map<Name, Name> getResults(Names players, Names results) {
        return IntStream.range(0, players.size())
                .boxed()
                .collect(Collectors.toMap(
                        players::get,
                        index -> results.get(move(index))
                ));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Line line : lines) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    private List<Line> createLines(int height, int playerCount) {
        return Stream.generate(() -> new Line(playerCount))
                .limit(height)
                .collect(Collectors.toList());
    }

    private int move(int index) {
        for (Line line : lines) {
            index += line.getDirection(index).getValue();
        }

        return index;
    }
}
