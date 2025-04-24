package nextstep.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.domain.Bonus;
import nextstep.domain.Name;
import nextstep.domain.Names;

/**
 * 입력 클래스
 */
public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    /** 참여 인원 입력 */
    public Names getName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String name = scanner.nextLine();
        return new Names(name);
    }

    /** 사다리 높이 */
    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public List<Bonus> getBonus(int count) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String bonus = scanner.nextLine();
        return parseBonus(bonus, count);
    }

    public String readTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        String target = scanner.nextLine();
        return target;
    }

    /** 결과 파싱 */
    private List<Bonus> parseBonus(String input, int count) {
        List<Bonus> bonus = splitAndTrim(input);
        // 보너스 개수 validation
        if (bonus.size() != count) {
            throw new IllegalArgumentException("보너스 개수는 사람 수와 일치해야 합니다.");
        }
        return bonus;
    }

    private List<Bonus> splitAndTrim(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Bonus::new)
            .collect(Collectors.toList());
    }
}
