package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<String> readPlayerNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitByComma(SCANNER.next());
    }

    public List<String> readPrizeNames() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return splitByComma(SCANNER.next());
    }

    private static List<String> splitByComma(String input) {
        return new ArrayList(Arrays.asList(input.split(DELIMITER)));
    }

    public static int readHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public String readSearchKeyPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.next();
    }
}
