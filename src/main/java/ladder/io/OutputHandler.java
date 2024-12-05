package ladder.io;


import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderResults;
import ladder.domain.nextstep.Players;

public interface OutputHandler {

    void showCommentForNamesOfPlayers();

    void showCommentForPlayResults();

    void showCommentForHeightOfLadder();

    void showLadderGameResult(Players players, Ladder ladder, LadderResults ladderResults);

    void showCommentForWhoseResultWantToSee();

    void showAllResults(LadderResults ladderResults);

    void showResultForPlayer(String nameOfPlayer, LadderResults ladderResults);

}
