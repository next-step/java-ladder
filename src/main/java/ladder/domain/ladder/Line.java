package ladder.domain.ladder;

import ladder.domain.player.People;
import ladder.domain.player.Person;
import ladder.utils.GenerateRandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
        for (int count = START_POINT; count < personCountForLine; count++) {
            ladderPoints.add(makePoint(people, count, GenerateRandomUtil.generateRandomBoolean()));
        }

        return ladderPoints;
    }

    public LadderPoint makePoint(People people, int count, boolean result) {

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
        List<LadderPoint> stepPoints = ladderPoints.stream().filter(ladderPoint -> ladderPoint.hasPosition(position)).collect(Collectors.toList());
        for (LadderPoint ladderPoint : stepPoints) {
            return nextStep(ladderPoint);
        }

        return null;
    }

    private Integer nextStep(LadderPoint ladderPoint) {
        if (ladderPoint.isNotPosition(START_POINT) && ladderPoints.get(ladderPoint.ladderPositionByMinusValue(DEFAULT_ONE)).isRightValue()) {
            return ladderPoints.get(ladderPoint.ladderPositionByMinusValue(DEFAULT_ONE)).getPosition();
        }

        if (ladderPoint.isNotPosition(ladderPoints.size()-DEFAULT_ONE) && ladderPoints.get(ladderPoint.getPosition()).isRightValue()) {
            return ladderPoints.get(ladderPoint.ladderPositionByPlusValue(DEFAULT_ONE)).getPosition();
        }

        return ladderPoint.getPosition();
    }

    public ArrayList<LadderPoint> getLadderPoints() {
        return ladderPoints;
    }
}
