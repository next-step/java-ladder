package nextstep.ladder.view;

import nextstep.ladder.domain.game.LadderGamePrize;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Order;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_PARTICIPANTS_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_MAXIMUM_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULT_USER_MESSAGE = "결과를 보고 싶은 사람은?";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static LadderGameUserStore askParticipantsName() {
        System.out.println(ASK_PARTICIPANTS_NAME_MESSAGE);
        String[] inputUserNames = SCANNER.nextLine().split(DELIMITER);
        List<LadderGameUser> gameUsers = Arrays.asList(inputUserNames).stream()
                .map(LadderGameUser::new)
                .collect(Collectors.toList());
        return new LadderGameUserStore(gameUsers);
    }

    public static int askMaximumLadderHeight() {
        System.out.println(ASK_MAXIMUM_LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static LadderGamePrize askLadderGamePrize() {
        System.out.println(ASK_RESULT_MESSAGE);
        String[] inputPrizes = SCANNER.nextLine().split(DELIMITER);
        Map<Order, String> ladderGamePrizes = new HashMap<>();

        for (int i = 0; i < inputPrizes.length; i++) {
            ladderGamePrizes.put(Order.of(i + 1), inputPrizes[i]);
        }

        return new LadderGamePrize(ladderGamePrizes);
    }

    public static String askResultUser() {
        System.out.println(ASK_RESULT_USER_MESSAGE);
        return SCANNER.nextLine();
    }
}

