package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MESSAGE2 = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getInputNames() {
        System.out.println(INPUT_MESSAGE);
        return Arrays.stream(scanner.nextLine().split(",")) // 쉼표 기준으로 분리
                .map(String::trim) // 앞뒤 공백 제거
                .peek(InputView::validateInput) // 자동차 이름 검증
                .collect(Collectors.toList());
    }

    public int getLadderCount() {
        System.out.println(INPUT_MESSAGE2);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 문자열 입니다.");
        }

        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + input);
        }
    }



}

