package ladder.model;


import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private Users participant;
    private Ladder ladder;

    public LadderGame(String[] users) {
        this.participant = new Users(users);
        this.ladder = new Ladder(users.length);
    }

    public void makeGame(int ladderHeight, LadderLineStrategy ladderLineStrategy) {
        ladder.makeLadder(ladderHeight, ladderLineStrategy);
    }

    public void gameResult(Prize prize) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < participant.participantsSize(); i++) {
            int result = getResult(i);
            resultList.add(result);
            participant.getParticipants()
                    .get(i)
                    .gameResult(prize.prizeInfo(result));
        }
    }

    public int getResult(int startPoint) {
        Lines lines = ladderInfo().getLines();
        List<Line> lineList = lines.getLineList();
        int result = startPoint;
        for (Line line : lineList) {
            result = moveSide(line.getPoints(), result);
        }
        return result;
    }

    public int moveSide(List<Boolean> pointList, int point) {
        boolean goLeft = false;
        boolean goRight = false;
        if (Boolean.TRUE.equals(pointList.get(point))) {
            goLeft = moveLeft(pointList, point);
            goRight = moveRight(pointList, point);
        }
        if (goLeft) {
            return point - 1;
        }
        if (goRight) {
            return point + 1;
        }
        return point;
    }

    public boolean moveLeft(List<Boolean> pointList, int point) {
        if (point > 0) {
            return pointList.get(point - 1);
        }
        return false;
    }

    public boolean moveRight(List<Boolean> pointList, int point) {
        if (point < pointList.size() - 1) {
            return pointList.get(point + 1);
        }
        return false;
    }

    public Ladder ladderInfo() {
        return this.ladder;
    }

    public Users getParticipant() {
        return this.participant;
    }
}
