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

        System.out.println("실행 결과를 입력하세요. (결과를 쉼표(,)로 구분하세요)");
        inputs.add(scanner.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        inputs.add(scanner.nextLine());

        return inputs;
    }

    public static String getPlayerResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
