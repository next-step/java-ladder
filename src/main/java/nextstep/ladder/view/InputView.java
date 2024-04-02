package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String COMMA = ",";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getUsersInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String names = scanner.nextLine();
        System.out.println();

        return Arrays.stream(names.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int getFloorInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String floor = scanner.nextLine();
        System.out.println();

        return Integer.parseInt(floor.trim());
    }

    public List<String> getLadderGameResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String ladderGameResults = scanner.nextLine();
        System.out.println();

        return Arrays.stream(ladderGameResults.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public String getGameResultTargetUser() {
        System.out.println("결과를 보고 싶은 사람은?");

        String gameResultTargetUser = scanner.nextLine();
        System.out.println();

        return gameResultTargetUser.trim();
    }
}
