package nextstep.step4.input;

import nextstep.step4.domain.UserInputTexts;

import java.util.Scanner;

public class Input {
    public static UserInputTexts inputUserNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String nameTexts = scanner.nextLine();

        return new UserInputTexts(nameTexts);
    }

    public static UserInputTexts inputUserResults() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String resultTexts = scanner.nextLine();

        return new UserInputTexts(resultTexts);
    }
}
