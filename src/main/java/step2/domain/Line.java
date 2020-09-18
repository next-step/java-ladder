package step2.domain;

import step2.util.LadderGameUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Line implements Iterable<Boolean>{
    private List<Boolean> pointList;

    public Line(List<Boolean> pointList) {
        this.pointList = pointList;
    }

    public static Line create(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("라인 생성시 적어도 한명 이상의 사다리게임 참가자가 필요합니다.");
        }

        List<Boolean> pointList = new ArrayList<>();

        for (int i = 0; i < countOfPerson; i++) {
            pointList.add(checkPointRule(i, pointList));
        }

        return new Line(pointList);
    }

    private static boolean checkPointRule(int currentInx, List<Boolean> pointList) {
        if (currentInx > 1) {
            return pointList.get(currentInx - 2) && pointList.get(currentInx - 1) ? false : LadderGameUtil.getRandomBoolean();
        }

        return LadderGameUtil.getRandomBoolean();
    }

    @Override
    public Iterator<Boolean> iterator() {
        return pointList.iterator();
    }
}
