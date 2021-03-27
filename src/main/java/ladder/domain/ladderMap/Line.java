package ladder.domain.ladderMap;

import ladder.domain.ParticipantList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private List<Point> points;

    public Line(ParticipantList participantList){
        this.points = IntStream.range(0, width(participantList))
                .mapToObj(Point::new)
                .collect(Collectors.toList());
    }

    private int width(ParticipantList participantList){
        return 10*(participantList.size()-1);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(Point::value)
                .collect(Collectors.joining());
    }
}
