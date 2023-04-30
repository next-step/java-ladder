package nextstep.ladder.view;

import nextstep.ladder.domain.Participants;

import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);
    private static String DELIMITER = ",";

    public static Participants inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Participants.init(SCANNER.nextLine().split(DELIMITER));
    }

}
