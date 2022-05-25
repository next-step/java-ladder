package nextstep.ladder.view;

import nextstep.ladder.domain.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String PARTICIPATION_USERNAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> readUserNames(){
        System.out.println(PARTICIPATION_USERNAME);
        String input = scanner.nextLine();
        return Stream.of(input.split(NAME_DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static int readMaxLadderLength(){
        System.out.println(MAX_LADDER_LENGTH);
        return Integer.parseInt(scanner.nextLine());
    }
}
