package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String[] userName = inputView.inputStringList("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] results = inputView.inputStringList("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        int height = inputView.inputInteger("최대 사다리 높이는 몇 개인가요?");
        Users users = new Users(userName);
        System.out.printf("사다리 결과 %n%n");
        outputView.printUserNameList(users);
        Ladder ladder = new Ladder(users.size(), height, results);
        outputView.printLadder(ladder);
        String name;
        do  {
            name = inputView.inputString("결과를 보고 싶은 사람은?");
            outputView.printResult(ladder, users, name);
        } while (!name.equals("all"));
    }
}
