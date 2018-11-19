package ladder.domain.ladder;

import ladder.domain.player.People;
import ladder.domain.player.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private ArrayList<LadderPoint> ladderPoints;

    public Line (People people) {
        ladderPoints = new ArrayList<>();
        int personCountForLine = people.peopleCount();
        IntStream.range(START_POINT, personCountForLine).forEach(count -> ladderPoints.add(makePoints(people, count)));
    }

    private LadderPoint makePoints(People people, int count) {

        Person person = people.getPerson(count);
        boolean result = new Random().nextBoolean();

        if (count == START_POINT) {
            return new LadderPoint(person, result);
        }

        if (count == people.peopleCount()-DEFAULT_ONE) {
            return new LadderPoint(person, false);
        }

        if (isNotValidateLine(ladderPoints.get(count-DEFAULT_ONE).isRightValue(), result))
            return new LadderPoint(person, false);

        return new LadderPoint(person, result);
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

    public Person findNextStep(Person person) {

        for (int i = START_POINT; i < ladderPoints.size(); i++) {
            LadderPoint ladderPoint = ladderPoints.get(i);

            if (ladderPoint.hasPerson(person)) {
                if (i != START_POINT && ladderPoints.get(i-DEFAULT_ONE).isRightValue()) {
                    return ladderPoints.get(i-DEFAULT_ONE).getPerson();
                }

                if (i != ladderPoints.size()-DEFAULT_ONE && ladderPoints.get(i).isRightValue()) {
                    return ladderPoints.get(i+DEFAULT_ONE).getPerson();
                }

                return ladderPoint.getPerson();
            }
        }

        return null;
    }
}
