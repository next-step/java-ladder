package nextstep.ladder.controller;

import nextstep.ladder.domain.People;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    resultView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    People people = inputView.inputNames();

    resultView.print("최대 사다리 높이는 몇 개인가요?");
    int maxLadder = inputView.inputInteger();

    resultView.print("실행 결과");
  }
}
