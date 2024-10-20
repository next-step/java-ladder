package step2.model;

import step2.ganerator.LadderGenerator;
import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final static String MINIMUM_LADDER_COUNT_MESSAGE = "사다리의 높이는 2이상이여여만 합니다.";

    private final static int MINIMUM_LADDER_COUNT = 2;

    private Person person;
    private final List<Line> line = new ArrayList<>();

    public void inputPerson(String personStr, int ladderSize) {
        confirmLadderCount(ladderSize);

        this.person = Person.createPerson(StringUtil.divideNum(personStr));
        for (int i = 0; i < ladderSize; i++) {
            line.add(Line.createLine(this.person, new LadderGenerator()));
        }
    }

    public List<Line> getLine() {
        return line;
    }

    public Person getPerson() {
        return person;
    }

    //생성하는 최대 사다리수를 체크한다.
    private void confirmLadderCount(int ladderSize) {
        if (ladderSize < MINIMUM_LADDER_COUNT) {
            throw new IllegalArgumentException(MINIMUM_LADDER_COUNT_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "Line=" + line +
                '}';
    }
}
