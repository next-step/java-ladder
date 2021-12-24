package nextstep.ladder.domain.view;

import nextstep.ladder.domain.participant.Participants;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String PARTICIPANTS_REQUEST = "참여할 사람의 이름을 입력하세요.";
    public static final String LADDER_HEIGHT_REQUEST = "최대 사다리 높이를 입력하세요.";

    public static Participants participants() {
        System.out.println(PARTICIPANTS_REQUEST);
        return Participants.from(scanner.nextLine());
    }

    public static int heightOfLadder() {
        System.out.println(LADDER_HEIGHT_REQUEST);
        return Integer.parseInt(scanner.nextLine());
    }
}
