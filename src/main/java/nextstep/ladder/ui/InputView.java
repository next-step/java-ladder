package nextstep.ladder.ui;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Rewards;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static JoinMembers createJoinMembers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new JoinMembers(SCANNER.nextLine());
    }

    public static Rewards createRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Rewards(SCANNER.nextLine());
    }


    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputResultMember() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
