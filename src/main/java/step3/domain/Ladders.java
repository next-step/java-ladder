package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private List<Ladder> ladderList = new ArrayList<>();

    public List<Ladder> getLadderList() {
        return ladderList;
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public void setLadders(int inputLadderHeight, LadderGame ladderGame, Players players) {
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

}
