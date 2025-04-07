package nextstep.ladder.view;

import nextstep.ladder.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_DELIMETER = ",";

    public static Players readPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();

        List<String> names = Arrays.stream(input.split(NAME_DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());

        return Players.from(names);
    }

    public static int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
