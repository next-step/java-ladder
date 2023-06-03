package ladder.view;

import java.util.Scanner;

public class InputView {
    public String promptNamesOfPersons() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public int promptHeightOfRadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Scanner(System.in).nextInt();
    }

    public String promptPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public String promptNameForResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return new Scanner(System.in).nextLine();
    }
}
