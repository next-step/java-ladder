package ladder.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String VALID_DELIMITER = ",";

    public String[] requestName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + VALID_DELIMITER + ")로 구분하세요)");
        String[] names = scanner.nextLine().split(VALID_DELIMITER);
        validateNames(names);
        return names;
    }

    private void validateNames(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("참여하는 사람의 수가 적습니다.");
        }
    }

    public int requestHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] requestLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = scanner.nextLine().split(VALID_DELIMITER);
        validateResults(results);
        return results;
    }

    private void validateResults(String[] results) {
        if(results.length < 2){
            throw new IllegalArgumentException("결과값의 수가 적습니다.");
        }
    }

    public String requestWhoseResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
