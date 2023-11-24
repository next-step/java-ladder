package nextstep.step4.responsibility.input;

import nextstep.step4.responsibility.domain.UserInputProvider;
import nextstep.step4.responsibility.domain.UserNames;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    @Override
    public UserInputProvider inputUserNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String nameTexts = scanner.nextLine();

        return new UserNames(nameTexts);
    }

    @Override
    public UserInputProvider inputUserResults() {
        return null;
    }

    @Override
    public int inputLadderHeight() {
        return 0;
    }

    @Override
    public String inputGamePlayerName() {
        return null;
    }
}
