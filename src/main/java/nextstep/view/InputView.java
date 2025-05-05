package nextstep.view;

import java.util.Scanner;

import nextstep.domain.Bonuses;
import nextstep.domain.Participants;

/**
 * 입력 클래스
 */
public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    /** 참여 인원 입력 */
    public Participants getName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String name = scanner.nextLine();
        return new Participants(name);
    }

    /** 사다리 높이 */
    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public Bonuses getBonus(int count) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String bonus = scanner.nextLine();
        return new Bonuses(bonus, count);
    }

    public String readTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        String target = scanner.nextLine();
        return target;
    }

}
