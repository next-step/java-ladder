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
        // 보상 입력 받기
        Rewards rewards = new Rewards(InputView.askRewards());
        // 참가자 명수와 보상 개수가 같은지 검증
        validateSize(people, rewards);
        // 사다리 개수 입력 받기
        int numberOfLadder = InputView.askMaxCountOfLadder();
        // 사다리 만들기
        LadderGame ladderGame = LadderGame.of(people, rewards, numberOfLadder);
        // 사다리 출력하기
        OutputView.printLadder(ladderGame);
        // 결과 출력
        boolean gameOver = false;
        do{
            // 결과를 출력하고 싶은 사람 이름 입력받기
            String wantResult = InputView.askPersonNameWantToKnowResult();
            PersonName personName = new PersonName(wantResult);
            // 결과 출력하기
            OutputView.printResult(ladderGame.makeResult(personName));
            // 전체 출력이면 게임 종료
            gameOver = personName.isAll();
        } while (!gameOver);

    }

    private static void validateSize(People people, Rewards rewards) {
        if(people.numberOfPeople() != rewards.numberOfRewards()){
            throw new IllegalArgumentException();
        }
    }

}
