package step2.domain;

import step2.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private static List<Player> playerList = new ArrayList<>();

    private static Ladders ladders = new Ladders();

    public void setPlayerList(String[] inputPlayers) {
        Arrays.asList(inputPlayers).forEach(x -> playerList.add(new Player(x)));
    }

    public void setLaddersHeight(int inputLadderHeight) {

        List<Ladder> ladderList = new ArrayList<>();
        //
        ladderList.add(new Ladder(inputLadderHeight, true));
        Ladder beforLader = ladderList.get(0);

        for (int i = 1; i < playerList.size() - 1; i++) {
            ladderList.add(new Ladder(inputLadderHeight, true, beforLader));
            beforLader = ladderList.get(i);
        }

        ladderList.add(new Ladder(inputLadderHeight, false, beforLader));

        ladders.setLadderList(ladderList);


    }

    public void outputView() {

        // print player
        OutputView.outputPlayer(playerList);

        // print ladder
        OutputView.outputLadder(ladders);

    }



    public List<Player> getPlayerList() {
        return playerList;
    }

    public Ladders getLadders() {
        return ladders;
    }

}
