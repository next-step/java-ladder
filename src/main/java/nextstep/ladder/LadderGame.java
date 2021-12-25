package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.RandomLadderPointStrategy;
import nextstep.ladder.domain.Step4LadderBuilder;
import nextstep.ladder.domain.Step4LadderFrame;
import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderBuilder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.view.Command;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        final List<String> names = InputView.inputNameOfPlayers();
        final List<String> resultList = InputView.inputPrizeOfResult();
        final int height = InputView.inputHeight();

        final LadderFrame ladderFrame = Step4LadderFrame.of(names, resultList);
        final LadderBuilder ladderBuilder = Step4LadderBuilder.of(ladderFrame, height);
        final Ladder ladder = ladderBuilder.build(new RandomLadderPointStrategy());

        OutputView.printLadder(ladder);

        GameResult gameResult = ladder.move(ladder.prizes());

        String nameOfUser = "";
        while(!nameOfUser.equalsIgnoreCase(Command.QUIT_COMMAND)) {
            nameOfUser = InputView.inputNameForResult();
            if (nameOfUser.equalsIgnoreCase(Command.QUIT_COMMAND)) {
                break;
            }

            OutputView.printResultOfPlayers(nameOfUser, gameResult);
        }
    }
}
