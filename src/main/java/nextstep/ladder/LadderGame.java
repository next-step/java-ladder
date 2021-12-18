package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderBuilder;
import nextstep.ladder.domain.LadderFrame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.ResultOfGame;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.line.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static String ALL_COMMAND = "all";
    public static String QUIT_COMMAND = "quit";

    public static void main(String[] args) {
        final List<String> names = InputView.inputCommaSeparateString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final List<String> resultList = InputView.inputCommaSeparateString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final int height = InputView.inputNumber("최대 사다리 높이는 몇 개인가요?");

        final LadderFrame ladderFrame = LadderFrame.of(Players.of(names), Results.fromString(resultList));
        final LadderBuilder ladderBuilder = LadderBuilder.of(ladderFrame, Height.of(height));
        final Ladder ladder = ladderBuilder.build(new RandomLineStrategy());

        OutputView.printLadder(ladderFrame, ladder);

        ResultOfGame resultOfGame = ladder.result(ladderFrame);

        String nameOfUser = "";
        while(!nameOfUser.equalsIgnoreCase(QUIT_COMMAND)) {
            nameOfUser = InputView.inputString("결과를 보고 싶은 사람은?");
            if (nameOfUser.equalsIgnoreCase(QUIT_COMMAND)) {
                break;
            }

            OutputView.printResultOfPlayers(nameOfUser, resultOfGame);
        }
    }
}
