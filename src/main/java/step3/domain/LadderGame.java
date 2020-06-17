package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static final int SINGLE_PLAYER_STATUS = 1;

    private static Players players;
    private static WinningPrizes winningPrizes;
    private static Ladders ladders = new Ladders();

    private LadderGame() {
        // block
    }

    private LadderGame(Players players, WinningPrizes winningPrizes, int laddersHeight) {
        if (laddersHeight < SINGLE_PLAYER_STATUS) {
            throw new IllegalArgumentException();
        }
        if (players.size() != winningPrizes.size()) {
            throw new IllegalArgumentException("Unmatched with player and winningPrize count.");
        }
        this.players = players;
        this.winningPrizes = winningPrizes;
        laddersHeight(laddersHeight);
    }

    public static LadderGame createLadder(Players players, WinningPrizes winningPrizes, int laddersHeight) {
        return new LadderGame(players, winningPrizes, laddersHeight);
    }

    private void laddersHeight(int inputLadderHeight) {
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

    public MatchingResult calculateWinningPrizeLine() {
        // result
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        String[] winningPrize = calculateLadder.calculateWinningPrizeLine(winningPrizes);
        MatchingResult matchingResult = MatchingResult.map(players, winningPrize);
        return matchingResult;
    }

    public Players getPlayers() {
        return players;
    }

    public WinningPrizes getWinningPrizes() {
        return winningPrizes;
    }

    public Ladders getLadders() {
        return ladders;
    }

}
