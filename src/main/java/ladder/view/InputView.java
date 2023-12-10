package ladder.view;

import java.util.Scanner;

import ladder.gilbert.domain.data.*;

public class InputView {

    public static Persons inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return new Persons(inputParser.parse(scanner.nextLine()));
    }

    public static LadderHeight inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return new LadderHeight(scanner.nextInt());
    }

    public static Goals inputGoals() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return new Goals(inputParser.parse(scanner.nextLine()));
    }

    public static Person inputPerson() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);
        return new Person(scanner.nextLine());
    }
}
