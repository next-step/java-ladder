package nextstep.refactoring;

import nextstep.ladder.view.InputView;
import nextstep.refactoring.ladder.engine.LadderCreator;
import nextstep.refactoring.ladder.factory.LadderFactoryBean;
import nextstep.refactoring.laddergame.engine.LadderGameCreator;
import nextstep.refactoring.laddergame.factory.LadderGameFactoryBean;
import nextstep.refactoring.view.console.ConsoleResultView;
import nextstep.refactoring.view.interfaces.ResultView;

public class LadderGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ConsoleResultView();

        LadderCreator ladderCreator = LadderFactoryBean.ladderCreator();
        LadderGameCreator ladderGameCreator = LadderGameFactoryBean.ladderGameCreator();

        LadderGameController controller = new LadderGameController(ladderCreator, ladderGameCreator);

        controller.startGame(inputView, resultView);
    }
}
