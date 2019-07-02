package nextstep.ladder.view;

public class OutView {
    private static String ASK_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String ASK_GAME_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static String LADDER_RESULT = "사다리 결과";
    private static String GAME_RESULT = "실행결과";
    private static String ASK_WHOES_RESULT = "결과를 보고 싶은 사람은?";

    public static void printBlankLine() {
        System.out.println();
    }

    public static void print(Object s) {
        System.out.print(s);
    }

    public static void println(Object s) {
        print(s + "\n");
    }

    public static void askPlayersName() {
        println(ASK_PLAYERS_NAME);
    }

    public static void setAskGameResult() {
        printBlankLine();
        println(ASK_GAME_RESULT);
    }

    public static void askLadderHeight() {
        printBlankLine();
        println(ASK_LADDER_HEIGHT);
    }

    public static void printLadder() {
        printBlankLine();
        println(LADDER_RESULT);
        printBlankLine();
    }

    public static void askWhoesResult() {
        printBlankLine();
        println(ASK_WHOES_RESULT);
    }

    public static void printResult(String result) {
        printBlankLine();
        println(GAME_RESULT);
        println(result);
    }
}
