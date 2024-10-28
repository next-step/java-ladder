package ladder.io;


import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.LadderResults;

public interface OutputHandler {

    void showCommentForNamesOfPlayers();

    void showCommentForPlayResults();

    void showCommentForHeightOfLadder();

    void showLadderGameResult(Players players, Ladder ladder, LadderResults ladderResults);

    void showCommentForWhoseResultWantToSee();

    void showAllResults(LadderResults ladderResults);

    void showResultForPlayer(String nameOfPlayer, LadderResults ladderResults);

}
