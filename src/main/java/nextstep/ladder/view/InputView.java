package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.exception.InputValueException;
import nextstep.ladder.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER_PATTERN = ",";

    private InputView() { }

    public static Players getPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputValue = SCANNER.nextLine();

        List<Player> players = Arrays.stream(inputValue.split(DELIMITER_PATTERN))
                .map(Player::newInstance)
                .collect(Collectors.toList());

        return Players.newInstance(players);
    }

    public static Height getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputValue = SCANNER.nextLine();

        validateInputValue(inputValue);

        return Height.newInstance(StringUtils.toInt(inputValue));
    }

    private static void validateInputValue(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InputValueException("데이터를 입력하세요.");
        }
    }
}
