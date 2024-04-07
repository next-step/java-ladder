package ladder.domain.ladder.point;

import java.util.List;

public class RandomPointAdd implements PointAddStrategy{

    @Override
    public List<PointEnum> makePoint(int countOfPerson) {
        return PointEnum.createRandomPoints(countOfPerson);
    }
}
