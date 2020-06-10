package step2.domain;

import step2.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    public static final int SINGLE_PLAYER_STATUS = 1;

    private static List<Player> players = new ArrayList<>();
    private static Ladders ladders = new Ladders();

    public void setPlayerList(String[] inputPlayers) {
        Arrays.asList(inputPlayers).forEach(x -> players.add(new Player(x)));
    }

    public void setLaddersHeight(int inputLadderHeight) {
        List<Ladder> laddersToSet = new ArrayList<>();

        if (players.size() == SINGLE_PLAYER_STATUS) {
            laddersToSet.add(new Ladder(inputLadderHeight, false));
        }
        if (players.size() > SINGLE_PLAYER_STATUS) {
            laddersToSet.add(new Ladder(inputLadderHeight, true));
            setLddersHeightMorePlayer(inputLadderHeight, laddersToSet);
        }

        ladders.setLadderList(laddersToSet);
    }

    private void setLddersHeightMorePlayer(int inputLadderHeight, List<Ladder> laddersToSet) {
        Ladder beforLader = laddersToSet.get(0);

        int playerSize = players.size();
        for (int i = 1; i < playerSize - 1; i++) {
            laddersToSet.add(new Ladder(inputLadderHeight, true, beforLader));
            beforLader = laddersToSet.get(i);
        }

        laddersToSet.add(new Ladder(inputLadderHeight, false, beforLader));
    }

    public void outputView() {
        // print player
        OutputView.outputPlayer(players);
        // print ladder
        OutputView.outputLadder(ladders);
    }

    public List<Player> getPlayerList() {
        return players;
    }

    public Ladders getLadders() {
        return ladders;
    }

}
