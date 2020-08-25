package nextstep.ladder;

import java.util.List;
import java.util.Scanner;
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

    // 사다리 데이터 생성
    Ladder ladder = LadderGenerator.generate(playerNames.size(), ladderHeight);

    // 출력
    ViewOutput.print(new LadderRenderer(playerNames, ladder));
  }


}
