package nextstep.ladder;

import java.util.List;
import java.util.Scanner;

import nextstep.ladder.biz.Chessmen;
import nextstep.ladder.biz.LadderAnalysis;
import nextstep.ladder.biz.LadderGenerator;
import nextstep.ladder.biz.Ladder;
import nextstep.ladder.ui.LadderRenderer;
import nextstep.ladder.ui.ViewInput;
import nextstep.ladder.ui.ViewOutput;

public class LadderGame {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 입력
    ViewInput viewInput = new ViewInput(scanner);
    List<String> playerNames = viewInput.requestPlayerNames();
    int ladderHeight = viewInput.requestLadderHeight();
    List<String> winningContents = viewInput.requestWinningContents();

    // 사다리 데이터 생성
    Ladder ladder = LadderGenerator.generate(playerNames.size(), ladderHeight);

    String playName = viewInput.requestPlayerWinning();

    LadderAnalysis ladderAnalysis = new LadderAnalysis(ladder);
    Chessmen chessmen0 = Chessmen.location(0);
    ladderAnalysis.stat(chessmen0);
    System.out.println(chessmen0);

    System.out.println();
    Chessmen chessmen1 = Chessmen.location(1);
    ladderAnalysis.stat(chessmen1);
    System.out.println(chessmen1);

    // 출력
    ViewOutput.print(new LadderRenderer(playerNames, ladder));
  }


}
