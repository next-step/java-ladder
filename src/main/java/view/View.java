package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class View {
    public static final String NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT = "실행 결과\n";
    public static final String LINE_COL = "      |";
    public static final String LINE_ROW = "------|";
    public static final String SPACE= " ";

    public static void showLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            System.out.println();
            System.out.print(LINE_COL);
            for (int i = 0; i < line.getPoints().size()-1; i++) {
                if(line.getPoints().get(i).isRight()){
                    System.out.print(LINE_ROW);
                }else{
                    System.out.print(LINE_COL);
                }
            }
        }
    }

    public static void showNames(String[] inputs) {
        for (String name : inputs) {
            System.out.printf("%6s",name);
                System.out.print(SPACE);

        }
    }
}
