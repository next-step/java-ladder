package laddergame.controller;

import laddergame.domain.People;
import laddergame.domain.PersonName;
import laddergame.domain.Rewards;
import laddergame.domain.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    public static void main(String[] args) {
        // 게임 참가자 이름 받기
        People people = new People(InputView.askPersonNames());
        // 실행 결과 입력 받기
        Rewards rewards = new Rewards(InputView.askRewards());
        rewards.validate(people);
        // 사다리 개수 입력 받기
        int numberOfLadder = InputView.askMaxCountOfLadder();
        // 사다리 만들기
        LadderGame ladderGame = LadderGame.of(people, rewards, numberOfLadder);
        // 사다리 출력하기
        OutputView.printLadder(ladderGame);
        // 결과를 출력하고 싶은 사람 이름 입력받기
        String wantResult = InputView.askPersonNameWantToKnowResult();
        // 결과 출력하기
        OutputView.printResult(ladderGame.getResult(new PersonName(wantResult)));
    }
}
