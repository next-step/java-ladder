package nextstep.ladder.view;

import nextstep.ladder.model.Gamers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public String receiveGamers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public List<String> receiveGameResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String result = scanner.nextLine();

        while (result == null || result.isEmpty()) {
            System.out.println("결과는 비어있을 수 없습니다. 다시 입력해주세요.");
            result = scanner.nextLine();
        }

        return convertToGameResult(result);
    }

    private List<String> convertToGameResult(String result) {
        return Arrays.stream(result.split(DELIMITER)).map(String::trim).collect(Collectors.toUnmodifiableList());
    }

    public int receiveMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = 0;

        try {
            height = scanner.nextInt();
            scanner.nextLine();
            System.out.println("최대 사다리 높이는 " + height + "입니다.");
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("유효한 숫자를 입력해 주세요.");
            return receiveMaxHeight();
        }
        return height;
    }

    public String receiveGamerNameForResult(Gamers gamers) {
        System.out.println("결과를 보고 싶은 사람은? (0 입력 시 종료됩니다.)");
        String gamer = scanner.nextLine();
        return validateGamer(gamer, gamers);
    }

    private String validateGamer(String gamer, Gamers gamers) {
        while (gamer == null || gamer.isEmpty()) {
            System.out.println("잘못된 이름입니다. 다시 입력 해주세요.");
            gamer = scanner.nextLine();
        }
        return gamer;
    }
}
