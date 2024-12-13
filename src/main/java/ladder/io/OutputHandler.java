package ladder.io;


import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.Rewards;

public interface OutputHandler {

    void showLadderGameResult(Players players, Ladder ladder, Rewards ladderResults);

    void showCommentForWhoseResultWantToSee();

    void showAllResults(LadderResult ladderResult);

    void showResultForPlayer(String nameOfPlayer, LadderResult ladderResult);

    void printResult(LadderResult result);
}
