package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.RandomGenerator;

public class Line {

    private final List<LadderConstructionStatus> points = new ArrayList<>();

    public Line(int countOfPerson) {
        initializeLine(countOfPerson);
    }

    private void initializeLine(int countOfPerson) {
        LadderConstructionStatus ladderConstructionStatus = new LadderConstructionStatus(false);
        for (int count = 0; count < countOfPerson - 1; count++) {
            ladderConstructionStatus = addLineValue(ladderConstructionStatus);
        }
    }

    private LadderConstructionStatus addLineValue(
        LadderConstructionStatus previousLadderConstructionStatus) {
        LadderConstructionStatus newStatus =
            previousLadderConstructionStatus.isLadderConstructionStatusFalse()
                ? new LadderConstructionStatus(RandomGenerator.createRandomBoolean())
                : new LadderConstructionStatus(false);
        points.add(newStatus);
        return newStatus;
    }

    public List<LadderConstructionStatus> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }
}
