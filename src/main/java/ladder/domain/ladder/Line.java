package ladder.domain.ladder;

import ladder.domain.player.People;
import ladder.domain.player.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private ArrayList<LadderPoint> ladderPoints;

    public Line () {
        ladderPoints = new ArrayList<>();
    }

    public List<LadderPoint> makeLineLadderPoints(People people) {
        int personCountForLine = people.peopleCount();
        IntStream.range(START_POINT, personCountForLine).forEach(count -> ladderPoints.add(makePoint(people, count)));
        return ladderPoints;
    }

    private LadderPoint makePoint(People people, int count) {

        boolean result = new Random().nextBoolean();

        if (count == START_POINT) {
            return new LadderPoint(count, result);
        }

        if (count == people.peopleCountByValue(DEFAULT_ONE)) {
            return new LadderPoint(count, false);
        }

        if (isNotValidateLine(ladderPoints.get(count-DEFAULT_ONE).isRightValue(), result))
            return new LadderPoint(count, false);

        return new LadderPoint(count, result);
    }

    public boolean isNotValidateLine(boolean preResult, boolean result) {
        return preResult && result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = START_POINT; i < ladderPoints.size(); i++) {
            if (i != ladderPoints.size()-DEFAULT_ONE) {
                stringBuilder.append(ladderPoints.get(i).toString());
            }
        }
        return stringBuilder.toString();
    }

    public Integer findNextStep(int position) {

        for (int i = START_POINT; i < ladderPoints.size(); i++) {
            LadderPoint ladderPoint = ladderPoints.get(i);

            if (ladderPoint.hasPosition(position)) {
                if (i != START_POINT && ladderPoints.get(i-DEFAULT_ONE).isRightValue()) {
                    return ladderPoints.get(i-DEFAULT_ONE).getPosition();
                }

                if (i != ladderPoints.size()-DEFAULT_ONE && ladderPoints.get(i).isRightValue()) {
                    return ladderPoints.get(i+DEFAULT_ONE).getPosition();
                }

                return ladderPoint.getPosition();
            }
        }

        return null;
    }
}
