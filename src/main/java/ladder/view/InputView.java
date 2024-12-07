package ladder.view;

import ladder.domain.engine.*;
import ladder.domain.factory.LadderFactory;
import ladder.domain.ns.NsLadder;
import ladder.domain.ns.generator.RandomCrossGenerator;
import ladder.exception.NoNameException;

import java.util.List;
import java.util.Scanner;

import static ladder.domain.engine.Results.NO_NAME_MESSAGE;

public class InputView {
    public static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_VERTICAL_SIZE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_REWARD_NAMES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    public static final String NOT_INPUT_TARGET_FIND_PLAYER_NAME_MESSAGE = "찾고자 하는 플레이어 이름을 입력하지 않았습니다.";
    public static final String PLAYERS_ALL = "all";
    private final Scanner scanner;
    private final LadderCreator ladderCreator;

    public InputView(Scanner scanner, LadderCreator ladderCreator) {
        this.scanner = scanner;
        this.ladderCreator = ladderCreator;
    }

    public Players inputNamesToPlayers() {
        try {
            return new Players(inputNames());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputNamesToPlayers();
        }
    }
    public Rewards inputNamesToRewards(Players players) {
        try {
            return new Rewards(inputRewardNames(), players.size());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputNamesToRewards(players);
        }
    }

    public Ladder inputVerticalSizeToLadder(Players players) {
        try {
            return ladderCreator.create(players, inputVerticalSize());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputVerticalSizeToLadder(inputNamesToPlayers());
        }
    }

    public List<PlayerName> inputResultPlayer(Players players) {
        try {
            return inputPlayers(players);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputResultPlayer(players);
        }
    }

    private List<PlayerName> inputPlayers(Players players) {
        System.out.println(INPUT_RESULT_MESSAGE);
        String text = scanner.nextLine();
        if (PLAYERS_ALL.equals(text)) {
            return players.names();
        }
        return List.of(players.names()
                .stream()
                .filter(playerName -> new PlayerName(text).equals(playerName))
                .findFirst()
                .orElseThrow(() -> new NoNameException(NO_NAME_MESSAGE)));
    }

    private String inputNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    private int inputVerticalSize() {
        System.out.println(INPUT_LADDER_VERTICAL_SIZE_MESSAGE);
        int inputVerticalSize = scanner.nextInt();
        scanner.nextLine();
        return inputVerticalSize;
    }

    private String inputRewardNames() {
        System.out.println(INPUT_REWARD_NAMES_MESSAGE);
        return scanner.nextLine();
    }
}
