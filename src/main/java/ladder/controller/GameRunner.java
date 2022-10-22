package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.RandomLineGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class GameRunner {
    public static void main(String[] args) {
        //입력값 받는 view 생성
        InputView inputView = new InputView();

        //참여자 이름 입력
        List<String> participantNames = inputView.enterParticipantName();

        //사다리 높이
        int ladderHeight = inputView.enterLadderHeight();

        //사다리 생성
        Ladder ladder = new Ladder(participantNames, ladderHeight, new RandomLineGenerator());
        int namesMaxLength = ladder.getNamesMaxLength();
        List<Line> lines = ladder.getLines();

        //결과 출력 view 생성
        ResultView resultView = new ResultView();

        //사다리 결과 출력
        resultView.printResultInitMessage();
        resultView.printParticipantNames(participantNames, namesMaxLength);
        resultView.printLadder(lines, namesMaxLength);
    }
}
