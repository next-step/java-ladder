package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMove {
    private List<Integer> positionList = new ArrayList<>();
    private List<Boolean> directionList = new ArrayList<>();

    public LadderMove(final List<Integer> positionList,final List<Boolean> directionList) {
        this.positionList = positionList;
        this.directionList = directionList;
        moveLadder();
    }

    private void moveLadder() {
        moveFirst();
        moveBody();
        moveLast();
    }

    private void moveBody() {
        LadderDirection ladderDirection;

        for (int i = 1; i < positionList.size() - 1; i++) {
            ladderDirection = new LadderDirection(directionList.get(i - 1), directionList.get(i));
            moveLadder(i, i + 1, ladderDirection.isRight());
        }
    }

    private void moveFirst() {
        moveLadder(0, 1, directionList.get(0));
    }

    private void moveLast() {
        moveLadder(positionList.get(positionList.size() - 2)
                , positionList.get(positionList.size() - 1)
                , directionList.get(directionList.size() - 1));
    }

    private void moveLadder(int firstIndex, int secondIndex, boolean moveCheck) {
        if (moveCheck) {
            int firstValue = this.positionList.get(firstIndex);
            int secondValue = this.positionList.get(secondIndex);

            positionList.set(firstIndex, secondValue);
            positionList.set(secondIndex, firstValue);
        }
    }

    public List<Integer> getPositionList() {
        return positionList;
    }
}
