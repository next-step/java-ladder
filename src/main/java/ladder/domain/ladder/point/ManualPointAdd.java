package ladder.domain.ladder.point;

import java.util.List;

public class ManualPointAdd implements PointAddStrategy{
    private final List<PointEnum> points;

    public ManualPointAdd(List<PointEnum> points) {
        this.points = points;
    }

    @Override
    public List<PointEnum> makePoint(int countOfPerson) {
        return PointEnum.createManualPoints(countOfPerson, points);
    }
}
