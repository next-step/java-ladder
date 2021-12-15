package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {

    private LadderGame() {
    }

    public static void main(String[] args) {
        String inputNames = InputView.nextLine("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int height = InputView.nextInt("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(inputNames, height);

        OutputView.print(ladder);
    }
}
