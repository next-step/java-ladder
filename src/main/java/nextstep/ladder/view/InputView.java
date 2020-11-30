package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public String inputParticipants() {
        System.out.println(INPUT_PARTICIPANTS);
        return scanner.nextLine();
    }
}
