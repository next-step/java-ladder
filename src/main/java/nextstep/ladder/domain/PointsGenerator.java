package nextstep.ladder.domain;

import java.util.List;

public interface PointsGenerator {
    List<Boolean> getPoints(NumberOfParticipants numberOfParticipants);
}
