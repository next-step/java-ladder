package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
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

        // 참가자 생성
        Players players = new Players(names);

        // 결과 생성
        Results results = new Results(inputResults);

        // 사다리 생성
        Ladder ladder = new Ladder(height, players.getSize(), new LineFactory(new RandomLineGenerator()));

        // 사다리 게임 생성
        LadderGame ladderGame = new LadderGame(players, ladder, results);

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
