package nextstep.ladder.domain.line;

import nextstep.ladder.domain.edge.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> value;

    public Lines(int width, Height height, LineFactory lineFactory) {
        this.value = Stream.generate(() -> lineFactory.create(width))
            .limit(height.getValue())
            .collect(Collectors.toList());
    }

    public int size() {
        return value.size();
    }

    public int lineSize() {
        if (size() == 0) {
            return 0;
        }
        return value.get(0).size();
    }

//    public Positions simulate() {
//        Positions res = new Positions();
//        int lineSize = lineSize();
//        for (int start = 0; start <= lineSize; start++) {
//            res.add(simulate(start));
//        }
//        return res;
//    }
//
//    private Position simulate(int start) {
//        Position position = new Position(start);
//        for (Line line: value) {
//            position = line.move(position);
//        }
//       return position;
//    }

    public List<List<Boolean>> getvalue() {
        return value.stream().map(Line::getValue).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Lines{" +
            "value=" + value +
            '}';
    }
}
