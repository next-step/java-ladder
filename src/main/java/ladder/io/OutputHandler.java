package ladder.io;


import ladder.domain.Ladder;
import ladder.domain.Players;

public interface OutputHandler {

    void showCommentForNamesOfPlayers();

    void showCommentForHeightOfLadder();

    void showLadderGameResult(Players players, Ladder ladder);
}
