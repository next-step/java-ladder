package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public String[] inputParticipateInUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine().split(",");
    }



}
