package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.view.InputView;
import nextstep.step2.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView.printMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participants = InputView.inputParticipants();

        InputView.printMessage("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(participants, ladderHeight);
        ResultView resultView = new ResultView(ladder.getNames(), ladder.getLadderLines());
        resultView.displayLadder();
    }
}
