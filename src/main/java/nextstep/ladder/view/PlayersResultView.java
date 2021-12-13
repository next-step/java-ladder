package nextstep.ladder.view;

import java.util.Map;
import nextstep.ladder.domain.InputString;
import nextstep.ladder.domain.Name;

public class PlayersResultView {

    private static final String END_KEY = "all";
    private static final String DELIMITER = " : ";
    private static final String NULL_MESSAGE = "존재하지 않는 참가자 명 입니다.";
    private static final String RESULT_MESSAGE = "실행 결과";

    private PlayersResultView() {
    }

    public static void gameResult(Map<Name, Name> playerResult) {
        String name = InputView.inputPlayerResult();
        while (END_KEY.equals(name)) {
            System.out.println(RESULT_MESSAGE);
            view(playerResult, Name.of(name));
            name = InputView.inputPlayerResult();
        }
        viewAll(playerResult);
    }

    private static void view(Map<Name, Name> playerResult, Name name) {
        Name result = playerResult.get(name);
        if (result == null) {
            System.out.println(NULL_MESSAGE);
            return;
        }
        System.out.println(result);
    }

    private static void viewAll(Map<Name, Name> playerResult) {
        System.out.println(RESULT_MESSAGE);
        for (Name player : playerResult.keySet()) {
            System.out.println(join(player, playerResult.get(player)));
        }
    }

    private static String join(Name player, Name item) {
        return String.join(DELIMITER, player.toString(), item.toString());
    }

}
