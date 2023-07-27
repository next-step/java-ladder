package nextstep.ladder.view;

import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.WinningItems;

import static nextstep.ladder.view.OutputView.print;

public class ConsoleLadderInputView implements LadderInputView {

    @Override
    public Players playersNameInput() {
        print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Players(InputView.input().split(","));
    }

    @Override
    public int ladderHeightInput() {
        print("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(InputView.input());
    }

    @Override
    public WinningItems winningItemNameInput(int countOfPlayers) {
        print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new WinningItems(countOfPlayers, InputView.input().split(","));
    }

    @Override
    public String gameResultPlayerInput() {
        print("결과를 보고 싶은 사람은?");
        return InputView.input();
    }
}
