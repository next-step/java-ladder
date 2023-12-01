package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String inputParticipant() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String[] splitParticipants(String participants) {
        return participants.split(",");
    }

    public int inputHighCount() {
        printEmpty();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private void printEmpty() {
        System.out.println("");
    }
}
