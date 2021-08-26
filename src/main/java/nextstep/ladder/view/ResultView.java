package nextstep.ladder.view;

import nextstep.ladder.domain.Game;

public class ResultView {

    public static void requestPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void requestLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printResult(Game game) {
        System.out.println("실행결과");
        System.out.println(game);
    }

    public static String parseBooleanToDot(boolean input) {
        if (input) {
            return "-----|";
        }
        return "     |";
    }
}
