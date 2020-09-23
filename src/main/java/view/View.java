package view;

import domain.Ladder;
import domain.Line;
import domain.User;

import java.util.List;

public class View {
    public static final String NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String RESULT_INPUT= "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_LADDER = "사다리 결과\n";
    public static final String RESULT_WANT= "결과를 보고 싶은 사람은?\n";
    public static final String RESULT = "실행 결과\n";
    public static final String LINE_COL = "      |";
    public static final String LINE_ROW = "------|";
    public static final String SPACE = " ";
    public static final int ONE = 1;

    private View(){}

    public static void showLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            System.out.println();
            System.out.print(LINE_COL);
            getRowLine(line);
        }
        System.out.println();
    }

    private static void getRowLine(Line line) {
        for (int i = 0; i < line.getPoints().size() - 1; i++) {
            if (line.getPoints().get(i).isRight()) {
                System.out.print(LINE_ROW);
                continue;
            }
            System.out.print(LINE_COL);
        }
    }

    public static void showNames(List<User> userNames) {
        for (User name : userNames) {
            System.out.printf("%6s", name.getName());
            System.out.print(SPACE);
        }
    }

    public static void showLadderResult(String[] results) {
        for (String result : results) {
            System.out.printf("%6s",result);
            System.out.printf(SPACE);
        }
        System.out.println();
    }

    public static void showResult(List<User> users, String name) {
        System.out.println(RESULT);

        if(name.equals("all")){
            for (User user : users) {
                System.out.println(user.getName() +" : "+user.getGameResult());
            }
            return;
        }
        for (User user : users) {
            if(name.equals(user.getName())){
                System.out.println(user.getName() +" : "+user.getGameResult());
            }
        }

    }
}
