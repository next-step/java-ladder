package nextstep.version.refactor;

import nextstep.version.refactor.domain.Participants;
import nextstep.version.refactor.domain.Rewards;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Participants createParticipants() {
        println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Participants result = new Participants(scanner.nextLine());
        println();
        return result;
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String template) {
        System.out.println(template);
    }

    public static Rewards createRewards() {
        println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Rewards result = new Rewards(scanner.nextLine());
        println();
        return result;
    }

    public static int getHeight() {
        println("최대 사다리 높이는 몇 개인가요?");
        Integer result = Integer.valueOf(scanner.nextLine());
        println();
        return result;
    }
}
