package nextstep.ladder.view;

import java.util.Map;
import nextstep.ladder.domain.Item;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.StringFactory;

public class PlayersResultView {

    private static final Name ALL = StringFactory.name("all");
    private static final String DELIMITER = " : ";
    private static final String NULL_MESSAGE = "존재하지 않는 참가자 명 입니다.";
    private static final String RESULT_MESSAGE = "실행 결과";

    private PlayersResultView() {
    }

    public static void gameResult(Map<Name, Item> playerResult) {
        Name name = StringFactory.name(InputView.inputPlayerResult());
        while (!ALL.equals(name)) {
            System.out.println(RESULT_MESSAGE);
            view(playerResult, name);
            name = StringFactory.name(InputView.inputPlayerResult());
        }
        viewAll(playerResult);
    }

    private static void view(Map<Name, Item> playerResult, Name name) {
        Item result = playerResult.get(name);
        if (result == null) {
            System.out.println(NULL_MESSAGE);
            return;
        }
        System.out.println(result);
    }

    private static void viewAll(Map<Name, Item> playerResult) {
        System.out.println(RESULT_MESSAGE);
        for (Name player : playerResult.keySet()) {
            System.out.println(join(player, playerResult.get(player)));
        }
    }

    private static String join(Name player, Item item) {
        return String.join(DELIMITER, player.toString(), item.toString());
    }

}
