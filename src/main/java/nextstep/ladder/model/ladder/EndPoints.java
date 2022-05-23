package nextstep.ladder.model.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EndPoints {

    private final List<EndPoint> endPoints;

    private EndPoints(List<EndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    public static EndPoints of(List<String> scores) {
        List<EndPoint> endPoints = scores
                .stream()
                .map(EndPoint::of)
                .collect(Collectors.toList());

        return new EndPoints(endPoints);
    }

    public List<EndPoint> unwrap() {
        return Collections.unmodifiableList(this.endPoints);
    }

    public EndPoint endPoint(int column) {
        return this.endPoints.get(column);
    }
}
