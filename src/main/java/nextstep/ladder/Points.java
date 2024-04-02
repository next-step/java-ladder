package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Points {

    private final List<Boolean> points = new ArrayList<>();

        public Points(int countOfPerson, GenerateStrategy strategy) {
            for (int i = 0; i < countOfPerson - 1; i++) {
                boolean hasLadder;
                //처음엔 랜덤으로 hasLadder가 결정
                if (i == 0) {
                    hasLadder = strategy.generate();
                    addLadderPoints(hasLadder);
                }
                // i가 1이상일 때, 이전의 가로선이 true이면 hasLadder를 false로 변경
                // i가 1이상일 때, 이전의 가로선이 false이면 hasLadder은 랜덤
                if (i >= 1) {
                    if (points.get(i - 1)) {
                        hasLadder = false;
                        addLadderPoints(hasLadder);
                    }
                    if (!points.get(i - 1)) {
                        hasLadder = new Random().nextBoolean();
                        addLadderPoints(hasLadder);
                    }
                }
            }
        }

    private void addLadderPoints(boolean hasLadder) {
            points.add(hasLadder);
    }

    public boolean isBlankLine(int index) {
        return points.get(index).equals(points.get(index + 1));
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
