package nextstep.ladder.view;

import nextstep.ladder.data.StepType;

import java.util.List;

public class Drawer {

    public static final String LADDER_POLE = "|";
    public static final String LINE_BREAK = "\n";

    public void printUserNames(List<String> names) {
        names.forEach(
                name -> System.out.printf("%6s", name)
        );
        System.out.println();
    }

    public void printLadderInfo(List<List<StepType>> ladderInfo) {
        StringBuffer stringBuffer = new StringBuffer();

        ladderInfo.forEach(
                line -> stringBuffer
                        .append(lineToString(line))
                        .append(LINE_BREAK)
        );
        System.out.println(stringBuffer);
    }

    private String lineToString(List<StepType> line) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append(StepType.drawOf(StepType.EMPTY))
                .append(LADDER_POLE);

        line.forEach(
                step -> stringBuffer
                        .append(StepType.drawOf(step))
                        .append(LADDER_POLE)
        );
        return stringBuffer.toString();
    }
}
