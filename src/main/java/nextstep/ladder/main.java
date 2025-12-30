package nextstep.ladder;


import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.ladder.LadderResults;
import nextstep.ladder.domain.ladder.Rewards;
import nextstep.ladder.domain.strategy.RandomLadderLineGenerateStrategy;
import nextstep.ladder.domain.user.Users;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.ResultView.resultPeople;

public class main {

    public static void main(String[] args) {

        Users users = inputName();
        Rewards rewards = inputReward();
        Height height = inputHeight();

        LadderGame ladderGame = new LadderGame(users, height, new RandomLadderLineGenerateStrategy(), rewards);

        printResultMessage();
        printLadders(ladderGame);

        LadderResults gameResult = ladderGame.play();

        printResultPeople();
        String name = inputResultPeople();
        resultPeople(gameResult, name);
    }
}
