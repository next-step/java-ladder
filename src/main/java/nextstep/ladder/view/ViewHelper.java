package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.view.OutputView.printPlainMessage;

public class ViewHelper {

    public static Participant insertParticipant(){
        printPlainMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Participant(InputView.inputString());
    }

    public static Height insertHeight(){
        printPlainMessage("최대 사다리 높이는 몇 개인가요?");
        return new Height(InputView.inputInt());
    }


    public static void printHeader(Participant participant){
        List<Name> name = participant.getName();
        String header = name.stream()
                .map(Name::toString)
                .collect(Collectors.joining(" "));
        printPlainMessage(header);
    }

    public static void printLadder(Lines entireLines){
        List<Line> lines = entireLines.getLines();
        StringBuilder sb = new StringBuilder();
        for(Line line : lines) {
            sb.append("     |");
            printPoints(sb, line.getLine());
            sb.append("\n");
        }
        printPlainMessage(sb.toString());
    }

    private static void printPoints(StringBuilder sb, List<Boolean> points) {
        for(Boolean point : points){
            sb.append(getPoint(point));
        }
    }

    private static String getPoint(Boolean point){
        if(point){
            return "-----|";
        }
        return "     |";
    }
}
