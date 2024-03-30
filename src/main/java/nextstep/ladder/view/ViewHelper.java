package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewHelper {

    public static Scanner scanner = new Scanner(System.in);

    public static Participant insertParticipant(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Participant(scanner.nextLine());
    }

    public static Height insertHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Height(scanner.nextInt());
    }


    public static void printHeader(Participant participant){
        List<Name> name = participant.getName();
        String header = name.stream()
                .map(Name::toString)
                .collect(Collectors.joining(" "));
        System.out.println(header);
    }

    public static void printLadder(Lines entireLines){
        List<Line> lines = entireLines.getLines();
        StringBuilder sb = new StringBuilder();
        for(Line line : lines) {
            sb.append("     |");
            printPoints(sb, line.getLine());
            sb.append("\n");
        }
        System.out.println(sb);
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
