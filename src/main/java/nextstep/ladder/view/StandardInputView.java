package nextstep.ladder.view;

import java.util.Scanner;

public class StandardInputView implements InputView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String[] getNames() {
        System.out.println("참여할 사람을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine().split(",");
    }

    @Override
    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }
}
