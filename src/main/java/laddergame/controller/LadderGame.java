package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Persons;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        // 게임 참가자 이름 받기
        Persons persons = new Persons(InputView.askPersonNames());
        // 사다리 개수 입력 받기
        int numberOfLadder = InputView.askMaxCountOfLadder();
        // 사다리 만들기
        Ladder ladder = new Ladder(persons, numberOfLadder);
        // 사다리 출력하기
        OutputView.printLadder(ladder);
    }
}
