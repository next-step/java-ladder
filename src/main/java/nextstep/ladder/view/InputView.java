package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public List<String> getPeopleNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public int getHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}
