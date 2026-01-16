package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.RandomLineGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        // 참가자 이름 입력 받기
        String names = InputView.inputNames();
        // 실행 결과 입력 받기
        String inputResults = InputView.inputResults();
        // 높이 입력 받기
        int height = InputView.inputHeight();

        LadderGame ladderGame = LadderGame.of(
                names,
                inputResults,
                height,
                new LineFactory(new RandomLineGenerator())
        );

        OutputView.printPlayers(ladderGame.getPlayers());
        OutputView.printLadder(ladderGame.getLines());
        OutputView.printResults(ladderGame.getResults());

        while (true) {
            String playerName = InputView.inputResultName();
            if (playerName.equalsIgnoreCase("all")) {
                OutputView.printAllResults(ladderGame);
                break;
            } else {
                OutputView.printResult(ladderGame, playerName);
            }
        }
    }
}
