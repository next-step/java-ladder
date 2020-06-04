package ladder.domain;

import java.util.Arrays;

public class LadderCreator {
    private final int countOfPerson;
    private final int ladderHeight;

    public LadderCreator(String[] personNames, int ladderHeight) {
        validate(personNames);
        this.countOfPerson = personNames.length;
        this.ladderHeight = ladderHeight;
    }

    private void validate(String[] personNames) {
        Arrays.stream(personNames).forEach(v -> {
            if (v.length() > 5) {
                throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입니다.");
            }
        });
    }

    public LineList createLadder() {
        LineList lineList = new LineList();
        for (int idx = 0; idx < ladderHeight; idx++) {
            lineList.createLine(countOfPerson);
        }
        return lineList;
    }

}
