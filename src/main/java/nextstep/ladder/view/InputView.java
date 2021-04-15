package nextstep.ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> getInfoFromClient() {
        List<String> inputs = new ArrayList<>();

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        inputs.add(scanner.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        inputs.add(scanner.nextLine());

        return inputs;
    }
}
