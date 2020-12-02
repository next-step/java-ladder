package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static Random random = new Random();

    // Line 은 라인사이의 있는 상태를 뜻하므로 -1 을 해줌
    private static int SUBTRACT_NUMBER = 1;

    /*
     * true가 사다리 사이 이어짐
     * false가 이어지지 않음
     * ex) List에 담긴 값이 차례대로 true, false, true 일 때 아래와 같이 존재
     * |----|    |----|
     */
    private List<Boolean> points = new ArrayList<>();

    public Line(final int countOfPerson) {
        initLineList(countOfPerson);
    }

    private void initLineList(final int countOfPerson) {

        for (int i = 0; i < countOfPerson - SUBTRACT_NUMBER; i++) {
            addPoint();
        }
    }

    private void addPoint() {
        if (points.size() == 0) {
            points.add(random.nextBoolean());

            return;
        }

        //연속으로 true가 나올경우
        if (this.points.get(points.size() - 1) == true) {
            this.points.add(false);

            return;
        }

        points.add(random.nextBoolean());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
