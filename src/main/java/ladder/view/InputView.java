package ladder.view;

import ladder.domain.Participants;
import ladder.domain.Rewards;
import ladder.domain.Target;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Participants inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Participants.of(scanner.nextLine());
    }

    public static Rewards inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Rewards.of(scanner.nextLine());
    }

    public static int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static Target inputTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        return new Target(scanner.nextLine());
    }
}
