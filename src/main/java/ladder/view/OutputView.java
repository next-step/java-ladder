package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String WIDTH_LADDER = "-----";
    private static final String HEIGHT_LADDER = "|";
    private static final String EMPTY_WIDTH_LADDER = "     ";
    private static final int EMPTY_WIDTH_NUMBER = 0;
    private static final int HEIGHT_NUMBER = 1;
    private static final int WIDTH_NUMBER = 2;


    public void printPaticipateInUsers(String[] userNames) {
        Arrays.stream(userNames).forEach(userName -> System.out.printf("%6s", userName));
        System.out.println();
    }

    public void printLadder(Lines lines){
        StringBuilder sb = new StringBuilder();
        for(Line line : lines){
            drawOneLine(sb, line);
        }
        System.out.println(sb.toString());
    }

    private void drawOneLine(StringBuilder sb, Line line) {
//        sb.append(EMPTY_WIDTH_LADDER);
//        for(Integer onePoint : line.lineInfoList()){
//            drawLadderByType(sb, onePoint);
//        }
//        sb.append("\n");

    }

    private void drawLadderByType(StringBuilder sb, Integer onePoint) {
        if(onePoint == EMPTY_WIDTH_NUMBER){
            sb.append(EMPTY_WIDTH_LADDER);
        }

        if(onePoint == HEIGHT_NUMBER){
            sb.append(HEIGHT_LADDER);
        }

        if(onePoint == WIDTH_NUMBER){
            sb.append(WIDTH_LADDER);
        }
    }
}
