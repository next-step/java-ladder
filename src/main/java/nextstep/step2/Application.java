package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String[] names = InputView.readNames("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int height = InputView.readLadderHeitht("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(height, names.length);

        OutputView.printLadder(ladder);
    }
}
