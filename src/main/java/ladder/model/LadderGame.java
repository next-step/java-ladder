package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private RandomLineStrategy randomLineStrategy = new RandomLineStrategy();
    private Users participant;
    private Lines lines;

    public LadderGame(String[] users) {
        this.participant = new Users(users);
    }

    public void game(int ladderHeight) {
        this.lines = new Lines();
        for (int height = 0; height < ladderHeight; height++) {
            List<Boolean> pointList = makeLine(new RandomLineStrategy());
            this.lines.addLine(new Line(pointList));
        }
    }

    public List<Boolean> makeLine(LadderLineStrategy ladderLineStrategy) {
        List<Boolean> pointList = new ArrayList<>();
        for (int userCount = 0; userCount < participant.participantsSize(); userCount = pointList.size()) {
            pointList.add(ladderLineStrategy.boolLine());
            makePointList(pointList, this.participant.participantsSize() - 1);
        }
        return pointList;
    }

    private void makePointList(List<Boolean> pointList, int userCount) {
        int currentIndex = pointList.size() - 1;
        if (pointList.get(currentIndex) && currentIndex < userCount) {
            pointList.add(true);
            ++currentIndex;
        }
        if (pointList.get(currentIndex) && currentIndex < userCount) {
            pointList.add(false);
            ++currentIndex;
        }
        if (currentIndex == userCount && !pointList.get(currentIndex - 1) && pointList.get(currentIndex)) {
            pointList.remove(currentIndex);
            pointList.add(false);
        }
    }

    public Lines getLines() {
        return this.lines;
    }

    public Users getParticipant() {
        return this.participant;
    }
}
