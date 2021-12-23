package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.LadderFrame;
import nextstep.ladder.domain.RandomLadderPointStrategy;
import nextstep.ladder.domain.ResultOfGame;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderBuilder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static final String ALL_COMMAND = "all";
    public static final String QUIT_COMMAND = "quit";

    public static void main(String[] args) {
        final List<String> names = InputView.inputNameOfPlayers();
        final List<String> resultList = InputView.inputPrizeOfResult();
        final int height = InputView.inputHeight();

        final LadderFrame ladderFrame = LadderFrame.of(names, resultList);
        final LadderBuilder ladderBuilder = nextstep.ladder.domain.LadderBuilder.of(ladderFrame, height);
        final Ladder ladder = ladderBuilder.build(new RandomLadderPointStrategy());

        OutputView.printLadder(ladder);

        ResultOfGame resultOfGame = ladder.resultOfGame();

        String nameOfUser = "";
        while(!nameOfUser.equalsIgnoreCase(QUIT_COMMAND)) {
            nameOfUser = InputView.inputNameForResult();
            if (nameOfUser.equalsIgnoreCase(QUIT_COMMAND)) {
                break;
            }

            OutputView.printResultOfPlayers(nameOfUser, resultOfGame);
        }
    }
}
