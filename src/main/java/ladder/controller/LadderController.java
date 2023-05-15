package ladder.controller;

import java.util.List;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderSizeInfo;
import ladder.domain.participant.Name;
import ladder.domain.ladder.MatchResult;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.participant.Participants;
import ladder.domain.strategy.RandomPointGenerationStrategy;
import ladder.view.input.InputHeightView;
import ladder.view.input.InputLadderResultView;
import ladder.view.input.InputNamesView;
import ladder.view.output.OutputLaddersResultView;
import ladder.view.output.OutputLaddersView;
import ladder.view.output.OutputNamesView;
import ladder.view.output.OutputPrizeResultView;

public class LadderController {

  public static void main (String[] args) {
    // 참가할 사람의 입력을 받기
    Participants participants = InputNamesView.scanPlayerNames();

    // 사다리 실행 결과를 입력 받기
    Prizes prizes = InputLadderResultView.scanPrizes(participants.size());

    // 사다리 높이 입력 받기
    Height height = InputHeightView.scanLadderHeight();

    LadderSizeInfo ladderSizeInfo = new LadderSizeInfo(height, participants);

    // 사다리 만들기
    Ladder ladder = Ladder.createLadder(ladderSizeInfo, new RandomPointGenerationStrategy());

    // 사다리 모양 출력하기 (참가자 이름, 사다리 모양, 사다리 실행 결과)
    OutputNamesView.printParticipantsNames(participants);
    OutputLaddersView.printRow(ladder);
    OutputLaddersResultView.printPrizes(prizes);

    // 사다리에 따라 결과 계산하기 (logic)
    while(true) {
      Name name = InputNamesView.scanPlayerName(participants);

      if (name.isAll()) {
        List<MatchResult> allResults = ladder.getAllResults(participants, prizes);
        OutputPrizeResultView.printAllResults(allResults);
        break;
      }

      Prize prize = ladder.getIndexOfResult(name, participants, prizes);
      OutputPrizeResultView.printResult(prize);

    }



  }

}
