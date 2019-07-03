package ladder.view;

import ladder.domain.Gamer;
import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;
import java.util.Scanner;

public class LadderView {
    private static final String GAMER_NAME_GUIDE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_GUIDE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RUN_RESULT = "실행결과";
    private static final String LADDER_MOVE_SYMBOL = "-";
    private static final String EMPTY_SYMBOL = " ";
    private static final String LADDER_HEIGHT_SYMBOL = "|";

    public void printGamerNameGuide() {
        printGuideStr(GAMER_NAME_GUIDE);
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printLadderHeightGuide() {
        printGuideStr(EMPTY_SYMBOL);
        printGuideStr(LADDER_HEIGHT_GUIDE);
    }

    public void printRunResultGuide() {
        printGuideStr(EMPTY_SYMBOL);
        printGuideStr(RUN_RESULT);
        printGuideStr(EMPTY_SYMBOL);
    }

    public void printGamer(Gamer gamer) {
        //FIXME
        List<String> names = gamer.getNames();
        for (String name : names) {
            if (name.length() < Gamer.MAX_GAMER_NAME_LENGTH) {
                String blankString = "";
                for (int index = 0; index < Gamer.MAX_GAMER_NAME_LENGTH - name.length(); index++) {
                    blankString += EMPTY_SYMBOL;
                }
                name = blankString + name;
            }
            System.out.print(name+EMPTY_SYMBOL);
        }
        printGuideStr("");
    }

    public void printLadder(Ladder ladder) {
        //FIXME
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            for (int index = 0; index < Gamer.MAX_GAMER_NAME_LENGTH; index++) {
                System.out.print(EMPTY_SYMBOL);
            }
            List<Boolean> points = line.getPoints();
            for (int index = 0; index < points.size(); index++) {
                System.out.print(LADDER_HEIGHT_SYMBOL);
                if (points.get(index)) {
                    for (int j = 0; j < Gamer.MAX_GAMER_NAME_LENGTH; j++) {
                        System.out.print(LADDER_MOVE_SYMBOL);
                    }
                }
                if (!points.get(index)) {
                    for (int j = 0; j < Gamer.MAX_GAMER_NAME_LENGTH; j++) {
                        System.out.print(EMPTY_SYMBOL);
                    }
                }
            }
            printGuideStr("");
        }
    }
    private void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }
}
