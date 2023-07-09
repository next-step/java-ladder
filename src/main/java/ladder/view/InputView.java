package ladder.view;

import java.util.Scanner;

public class InputView {
    public static String promptNamesOfPersons() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public static int promptHeightOfRadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Scanner(System.in).nextInt();
    }

    public static String promptPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public static String promptNameForResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String name =  new Scanner(System.in).nextLine();

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 입력되지 않았습니다.");
        }

        return name;
    }
}
