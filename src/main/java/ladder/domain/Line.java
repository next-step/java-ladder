package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Boolean DEFAULT_POINT = false;
    private static final int FALSE_NUMBER = 0;

    private List<Boolean> points;

    private Line (List<Boolean> points) {
        this.points = points;
    }

    public static Line countGamerOf(int countOfGamer) throws IllegalArgumentException {
        if (countOfGamer < Gamer.MIN_GAMER_COUNT) {
            throw new IllegalArgumentException("게임 참여자는 최소 두명 이상이여야 합니다.");
        }

        List<Boolean> points = new ArrayList<>();
        Random random = new Random();
        int randomNumber = random.nextInt(countOfGamer);
        for (int index = 0; index < countOfGamer - 1; index++) {
            boolean pointValue = (FALSE_NUMBER != randomNumber);
            points.add(pointValue);
            randomNumber = getNumber(pointValue, random.nextInt(countOfGamer));
        }
        points.add(DEFAULT_POINT);

        return new Line(points);
    }

    private static int getNumber(boolean pointValue, int randomNumber) {
        if (!pointValue) {
            return randomNumber;
        }
        return FALSE_NUMBER;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
