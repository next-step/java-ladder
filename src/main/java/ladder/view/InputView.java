package ladder.view;

import java.util.Scanner;

import ladder.domain.data.*;

import static ladder.view.inputParser.parse;

public class InputView {

    public static PersonNames inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return new PersonNames(parse(scanner.nextLine()));
    }

    public static LadderHeight inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return new LadderHeight(scanner.nextInt());
    }

    public static Goals inputGoals() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return new Goals(parse(scanner.nextLine()));
    }
}
