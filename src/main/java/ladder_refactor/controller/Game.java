package ladder_refactor.controller;


import ladder_refactor.domain.*;
import ladder_refactor.view.InputView;
import ladder_refactor.view.ResultView;

public class Game {

    public void play() {
        String inputPlayers = InputView.questionPlayers();
        Players players = Players.of(inputPlayers);

        String inputAnswers = InputView.questionAnswers();
        Answers answers = Answers.of(inputAnswers, players);

        String height = InputView.questionHeight();
        Height ladderHeight = Height.of(height);

        Ladder ladder = Ladder.init(ladderHeight.getSize(), players.count());
        result(players, ladder, answers);
    }

    public void result(Players players, Ladder ladder, Answers answers) {
        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printAnswer(answers);

        String findResult = InputView.questionFindResult();
        if (ResultView.isAllResult(findResult)) {
            ResultView.printResultText();
            printAllResult(players, ladder, answers);
            return;
        }

        int index = players.getPlayerIndex(new Player(findResult));
        int resultIndex = ladder.move(index);
        ResultView.printResult(answers, resultIndex);

    }

    private void printAllResult(Players players, Ladder ladder, Answers answers) {
        players.getPlayers().forEach(x -> {
            int playerIndex = players.getPlayerIndex(x);
            String result = answers.getResult(ladder.move(playerIndex));
            ResultView.printResults(x, result);
        });
    }
}
