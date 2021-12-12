package nextstep.ladder.view;

import java.util.Map;
import nextstep.ladder.domain.Item;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.StringFactory;
import nextstep.ladder.util.ScannerUtils;

public class PlayersResultView {

    private static final Name ALL = StringFactory.name("all");
    private static final String DELIMITER = " : ";
    private static final String NULL_MESSAGE = "존재하지 않는 참가자 명 입니다.";

    private PlayersResultView() {
    }

    public static void gameResult(Map<Name, Item> playerResult) {
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            Name name = StringFactory.name(ScannerUtils.nextLine());

            System.out.println("\n실행 결과");
            if (ALL.equals(name)) {
                viewAll(playerResult);
                break;
            }

            view(playerResult, name);
        }
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
        for (Name player : playerResult.keySet()) {
            System.out.println(join(player, playerResult.get(player)));
        }
    }

    private static String join(Name player, Item item) {
        return String.join(DELIMITER, player.toString(), item.toString());
    }
}
