package nextstep.ladder.view;

import java.util.Map;
import nextstep.ladder.domain.Name;
import nextstep.ladder.util.ScannerUtils;

public class PlayersResultView {

    private static final Name ALL = Name.from("all");
    private static final String DELIMITER = " : ";
    private static final String NULL_MESSAGE = "존재하지 않는 참가자 명 입니다.";

    private PlayersResultView() {
    }

    public static void gameResult(Map<Name, String> playerResult) {
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            Name name = Name.from(ScannerUtils.nextLine());

            System.out.println("\n실행 결과");
            if (ALL.equals(name)) {
                viewAll(playerResult);
                break;
            }

            view(playerResult, name);
        }
    }

    private static void view(Map<Name, String> playerResult, Name name) {
        String result = playerResult.get(name);
        if (result == null) {
            result = NULL_MESSAGE;
        }

        System.out.println(result);
    }

    private static void viewAll(Map<Name, String> playerResult) {
        for (Name player : playerResult.keySet()) {
            System.out.println(player.toString() + DELIMITER + playerResult.get(player));
        }
    }
}
