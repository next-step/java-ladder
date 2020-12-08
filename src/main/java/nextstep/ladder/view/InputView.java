package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    final static String COMMA = ",";

    Scanner scanner = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitByDelimiter(scanner.nextLine());
    }

    private List<String> splitByDelimiter(String names) {
        return Arrays.asList(names.split(COMMA));
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
