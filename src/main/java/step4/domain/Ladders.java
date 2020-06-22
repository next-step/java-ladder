package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private List<Ladder> ladderList = new ArrayList<>();

    public List<Ladder> getLadderList() {
        return ladderList;
    }

    public int getSize() {
        return ladderList.size();
    }

    public int getLineSize() {
        if (getSize() != 0) {
            return ladderList.get(0).getLineCount();
        }
        return 0;
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public void setLadders(int inputLadderHeight, Players players) {
        List<Ladder> laddersToSet = new ArrayList<>();
        // single play
        if (players.size() == LadderGame.SINGLE_PLAYER_STATUS) {
            laddersToSet.add(new Ladder(inputLadderHeight, false));
            setLadderList(laddersToSet);
            return;
        }
        // multi play
        laddersToSet.add(new Ladder(inputLadderHeight, true));
        setLddersHeightMorePlayer(inputLadderHeight, laddersToSet, players);
        setLadderList(laddersToSet);
        return;
    }

    private void setLddersHeightMorePlayer(int inputLadderHeight, List<Ladder> laddersToSet, Players players) {
        Ladder beforLader = laddersToSet.get(0);
        int playerSize = players.size();
        for (int i = 1; i < playerSize - 1; i++) {
            laddersToSet.add(new Ladder(inputLadderHeight, true, beforLader));
            beforLader = laddersToSet.get(i);
        }
        laddersToSet.add(new Ladder(inputLadderHeight, false, beforLader));
    }

    protected void markingPointStep() {
        for (int i = 0; i < getSize(); i++) {
            Ladder ladder = getLadderList().get(i);
            if (i == 0) {
                markingFirstLineWithoutLeftDirection(i, ladder);
            }
            if (i >= 1) {
                Ladder beforeLadder = getLadderList().get(i - 1);
                markingLine(getSize(), i, ladder, beforeLadder);
            }
        }
    }


    private void markingLine(int laddersCount, int i, Ladder ladder, Ladder beforeLadder) {
        for (int j = 0; j < ladder.getLineCount(); j++) {
            Line line = ladder.getLines().get(j);
            Line beforeLine = beforeLadder.getLines().get(j);
            if (i != laddersCount) {
                line.setPointSetp(PointStep.RIGHT, line.isCanStepable());
            }
            if (beforeLine.isCanStepable()) {
                line.setPointSetp(PointStep.LEFT);
            }
            if (!beforeLine.isCanStepable() && !line.isCanStepable()) {
                line.setPointSetp(PointStep.NONE);
            }
            if (beforeLine.isCanStepable() && !line.isCanStepable()) {
                line.setPointSetp(PointStep.LEFT);
            }
        }
    }

    private void markingFirstLineWithoutLeftDirection(int i, Ladder ladder) {
        for (int j = 0; j < ladder.getLineCount(); j++) {
            Line line = ladder.getLines().get(j);
            PointStep pointStep = line.isCanStepable() ? PointStep.RIGHT :
                    PointStep.NONE;
            line.setPointSetp(pointStep);
        }
    }

}
