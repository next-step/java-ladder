package ladder_refactor.controller;


import ladder_refactor.view.InputView;

public class Game {

    public void play() {
        String inputPlayers = InputView.questionPlayers();

        String inputAnswers = InputView.questionAnswers();

        String height = InputView.questionHeight();
    }
}
