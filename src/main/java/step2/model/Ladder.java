package step2.model;

import step2.ganerator.LadderGenerator;
import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final static String MINIMUM_PERSON_COUNT_MESSAGE = "참여 인원은 2명이상이여야 합니다.";
    private final static String MINIMUM_LADDER_COUNT_MESSAGE = "사다리의 높이는 2이상이여여만 합니다.";

    private final static int MINIMUM_PERSON_COUNT = 2;
    private final static int MINIMUM_LADDER_COUNT = 2;

    private String[] person;
    private final List<Line> line = new ArrayList<>();

    public void inputPerson(String personStr, int ladderSize) {
        String[] personArr = StringUtil.divideNum(personStr);
        confirmPersonCount(personArr);
        confirmLadderCount(ladderSize);
        this.person = personArr;
        for (int i = 0; i < ladderSize; i++) {
            line.add(Line.createLine(personArr, new LadderGenerator()));
        }
    }

    public List<Line> getLine() {
        return line;
    }

    public String[] getPerson() {
        return person;
    }

    //참여하는 인원수를 체크한다.
    private void confirmPersonCount(String[] personArr) {
        if (personArr.length < MINIMUM_PERSON_COUNT) {
            throw new IllegalArgumentException(MINIMUM_PERSON_COUNT_MESSAGE);
        }
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
