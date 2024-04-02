package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Boolean> points = new ArrayList<>();

    public Points(int countOfPerson, GenerateStrategy strategy) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean hasLadder = strategy.generate();
            //처음엔 랜덤으로 hasLadder가 결정
            if (i == 0) {
                addLadderPoints(hasLadder);
            }
            // i가 1이상일 때, 이전의 가로선이 true이면 hasLadder를 false로 변경
            // i가 1이상일 때, 이전의 가로선이 false이면 hasLadder은 랜덤
            if (i >= 1) {
                if (points.get(i - 1)) {
                    addLadderPoints(false);
                }
                if (!points.get(i - 1)) {
                    addLadderPoints(hasLadder);
                }
            }
        }
    }

    private void addLadderPoints(boolean hasLadder) {
        points.add(hasLadder);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
