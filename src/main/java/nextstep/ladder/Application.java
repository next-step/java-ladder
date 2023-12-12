package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String[] userName = inputView.inputNameList("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int height = inputView.inputInteger("최대 사다리 높이는 몇 개인가요?");
        LadderGame ladderGame = new LadderGame();
        Users users = ladderGame.registerUser(userName);
        System.out.printf("실행 결과 %n%n");
        outputView.printUserNameList(users);
        outputView.printLadder(ladderGame.makeLadder(users, height));
    }
}
