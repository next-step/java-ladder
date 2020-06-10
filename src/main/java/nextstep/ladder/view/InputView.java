package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.exception.InputValueException;
import nextstep.ladder.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER_PATTERN = ",";
    private static final String NEW_LINE = System.lineSeparator();

    private InputView() { }

    public static Players getPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputValue = SCANNER.nextLine();

        String[] playerTokens = inputValue.split(DELIMITER_PATTERN);
        List<Player> players = IntStream.range(0, playerTokens.length)
                .mapToObj(index -> Player.newInstance(playerTokens[index], index))
                .collect(Collectors.toList());

        return Players.newInstance(players);
    }
    
    public static Rewards getResults(int countOfPlayer) {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputValue = SCANNER.nextLine();

        List<Reward> rewards = Arrays.stream(inputValue.split(DELIMITER_PATTERN))
                .map(Reward::newInstance)
                .collect(Collectors.toList());

        return Rewards.newInstance(rewards, countOfPlayer);
    }

    public static Height getHeight() {
        System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
        String inputValue = SCANNER.nextLine();

        validateInputValue(inputValue);

        return Height.newInstance(StringUtils.toInt(inputValue));
    }

    private static void validateInputValue(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InputValueException("데이터를 입력하세요.");
        }
    }

    public static PlayerName getPlayerName() {
        System.out.println(NEW_LINE + "결과를 보고 싶은 사람은?");
        return PlayerName.newInstance(SCANNER.nextLine());
    }
}
