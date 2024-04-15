package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.RandomBooleanGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    People people = inputView.inputNames();
    LadderPrize prize = inputView.inputPrizes();

    resultView.print("최대 사다리 높이는 몇 개인가요?");
    int maxLadder = inputView.inputInteger();
    Ladder ladder = new Ladder(people, maxLadder, new RandomBooleanGenerator());

    resultView.print("실행 결과");
    resultView.printLadder(ladder.getLadder());
  }
}
