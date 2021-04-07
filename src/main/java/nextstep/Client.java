package nextstep;

import nextstep.view.InputView;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String namesString = inputView.inputQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String ladderCountString = inputView.inputQuestion("최대 사다리 높이는 몇 개인가요?");

        int ladderCount = Integer.parseInt(ladderCountString);
        String[] names = namesString.split(",");
        Ladder ladder = new Ladder(ladderCount);
        for (String name : names) {
            ladder.add(name);
        }
    }
}
