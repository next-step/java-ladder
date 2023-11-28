package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public String inputParticipators() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
