package nextstep.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 입력 클래스
 */
public class InputView {
    private static final int MAX_NAME_LENGTH = 5;
    private final Scanner scanner = new Scanner(System.in);

    /** 참여 인원 입력 */
    public List<String> getName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String name = scanner.nextLine();
        return parseName(name);
    }

    /** 사다리 높이 */
    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        return height;
    }

    public List<String> getBonus(int count) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String bonus = scanner.nextLine();
        return parseBonus(bonus, count);
    }

    /** 이름 파싱 */
    private List<String> parseName(String input) {
        List<String> names = splitAndTrim(input);
        // 빈 이름 체크
        if (names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }
        // 길이 체크
        if (names.stream().anyMatch(this::isGraterThanMaxLength)) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "자까지 허용됩니다.");
        }
        return names;
    }

    /** 이름 길이 validation */
    private boolean isGraterThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    /** 결과 파싱 */
    private List<String> parseBonus(String input, int count) {
        List<String> bonus = splitAndTrim(input);
        // 보너스 개수 validation
        if (bonus.size() != count) {
            throw new IllegalArgumentException("보너스 개수는 사람 수와 일치해야 합니다.");
        }
        return bonus;
    }

    private List<String> splitAndTrim(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
