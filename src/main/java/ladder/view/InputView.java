package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String PRIZE_DELIMITER = ",";

    private InputView() {}

    public static Players askPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<Player> players = parsePlayerNames(SCANNER.nextLine());
        return Players.of(players);
    }

    private static List<Player> parsePlayerNames(String namesStr) {
        return Arrays.stream(namesStr.split(PLAYER_NAME_DELIMITER))
                .map(name -> Player.of(name.trim()))
                .collect(Collectors.toList());
    }

    public static LadderHeight askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return LadderHeight.of(SCANNER.nextInt());
    }

    public static Prizes askPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<Prize> prizes = parsePrizes(SCANNER.nextLine());
        return Prizes.of(prizes);
    }

    private static List<Prize> parsePrizes(String prizesStr) {
        return Arrays.stream(prizesStr.split(PRIZE_DELIMITER))
                .map(name -> Prize.of(name.trim()))
                .collect(Collectors.toList());
    }
}
