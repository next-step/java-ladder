package ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    public List<String> names;
    public int ladderHeight = 0;

    public void saveInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String nameStr = scanner.nextLine();
        names= Arrays.asList(split(nameStr));
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        ladderHeight = scanner.nextInt();
    }

    private String[] split(String str) {
        return str.split(",");
    }


}
