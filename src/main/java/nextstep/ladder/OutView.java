package nextstep.ladder;

public class OutView {
    private static String ASK_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static String GAME_RESULT = "실행결과";

    public static void print(Object s) {
        System.out.print(s);
    }

    public static void println(Object s) {
        print(s + "\n");
    }

    public static void askPlayersName() {
        println(ASK_PLAYERS_NAME);
    }

    public static void askLadderHeight() {
        println(ASK_LADDER_HEIGHT);
    }
}
