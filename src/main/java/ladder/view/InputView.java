package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = SCANNER.nextLine();
        System.out.println();
        return Arrays.asList(names.split(","));
    }

    public List<String> inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String prizes = SCANNER.nextLine();
        System.out.println();
        return Arrays.asList(prizes.split(","));
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();
        return height;
    }

    public String inputNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String name = SCANNER.nextLine();
        System.out.println();
        return name;
    }

}
