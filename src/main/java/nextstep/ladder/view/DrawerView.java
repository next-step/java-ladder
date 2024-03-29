package nextstep.ladder.view;

import nextstep.ladder.data.StepType;

import java.util.List;

public class DrawerView {

    public static final String LADDER_POLE = "|";
    public static final String LINE_BREAK = "\n";
    public static final String EMPTY = "     ";
    public static final String STEP = "-----";

    public void printLadderGameResult(List<String> names, List<List<StepType>> ladderInfo) {
        System.out.println("실행 결과\n");

        printUserNames(names);
        printLadderInfo(ladderInfo);
    }

    private void printUserNames(List<String> names) {
        names.forEach(
                name -> System.out.printf("%6s", name)
        );
        System.out.println();
    }

    private void printLadderInfo(List<List<StepType>> ladderInfo) {
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
                .append(EMPTY)
                .append(LADDER_POLE);

        line.forEach(
                step -> stringBuffer
                        .append(getStepWithStepType(step))
                        .append(LADDER_POLE)
        );
        return stringBuffer.toString();
    }

    private String getStepWithStepType(StepType stepType) {
        if (stepType == StepType.EMPTY) {
            return EMPTY;
        }

        return STEP;
    }
}
