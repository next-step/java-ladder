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
    }
}
