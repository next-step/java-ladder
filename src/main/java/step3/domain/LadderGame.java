package step3.domain;

import step3.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    public static final int SINGLE_PLAYER_STATUS = 1;
    private static List<Player> players = new ArrayList<>();
    private static String[] winningPrize = {};
    private static Ladders ladders = new Ladders();

    private LadderGame() {
        // block
    }

    public LadderGame(String[] playerNames, String[] winningPrize, int laddersHeight) {
        if (playerNames.length == 0) {
            throw new IllegalArgumentException();
        }
        if (laddersHeight < SINGLE_PLAYER_STATUS) {
            throw new IllegalArgumentException();
        }
        if (playerNames.length != winningPrize.length) {
            throw new IllegalArgumentException("Unmatched with player and winningPrize count.");
        }

        setPlayerList(playerNames);
        setWinningPrize(winningPrize);
        setLaddersHeight(laddersHeight);
    }

    public static LadderGame of(String[] playerNames, String[] winningPrize, int laddersHeight) {
        return new LadderGame(playerNames, winningPrize, laddersHeight);
    }

    private void setPlayerList(String[] inputPlayers) {
        Arrays.asList(inputPlayers).forEach(x -> players.add(new Player(x)));
    }
    private void setWinningPrize(String[] winningPrize) {
        this.winningPrize = winningPrize;
    }

    private void setLaddersHeight(int inputLadderHeight) {
        List<Ladder> laddersToSet = new ArrayList<>();

        // single play
        if (players.size() == SINGLE_PLAYER_STATUS) {
            laddersToSet.add(new Ladder(inputLadderHeight, false));
            ladders.setLadderList(laddersToSet);
            return;
        }
        // multi players
        if (players.size() > SINGLE_PLAYER_STATUS) {
            laddersToSet.add(new Ladder(inputLadderHeight, true));
            setLddersHeightMorePlayer(inputLadderHeight, laddersToSet);
            ladders.setLadderList(laddersToSet);
            return;
        }

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
        // print winning Prize
        OutputView.winningPrize(winningPrize);


    }

    public List<Player> getPlayerList() {
        return players;
    }

    public Ladders getLadders() {
        return ladders;
    }

}
