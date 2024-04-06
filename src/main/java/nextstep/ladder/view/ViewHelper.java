package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewHelper {

    public static Scanner scanner = new Scanner(System.in);

    public static Participants insertParticipant(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Participants(scanner.nextLine());
    }

    public static Height insertHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Height(scanner.nextInt());
    }

    public static void printBottom(ExecutionResults executionResults) {
        List<ExecutionResult> results = executionResults.getExecutionResults();
        String header = results.stream()
                .map(iter -> prependSpace(iter.getExecutionResult()))
                .collect(Collectors.joining(" "));
        System.out.println(header);
    }

    public static ExecutionResults insertExecutionResults(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new ExecutionResults(scanner.nextLine());
    }


    public static void printHeader(Participants participants){
        System.out.println("사다리 결과");
        List<Name> name = participants.getName();
        String header = name.stream()
                .map(iter -> prependSpace(iter.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(header);
    }

    public static void printLadder(Lines entireLines){
        List<Line> lines = entireLines.getLines();
        StringBuilder sb = new StringBuilder();
        for(Line line : lines) {
            sb.append("     |");
            printPoints(sb, line.getLine());
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
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

    private static String prependSpace(String value){
        if(value.length() >= 5){
            return value;
        }
        String substring = "     ".substring(0, 5 - value.length());
        return substring + value;
    }

    public static void printResult(LadderMapping ladderMapping, Participants participants){
        while(true){
            System.out.println("결과를 보고 싶은 사람은?");
            String viewer = new Scanner(System.in).nextLine();
            System.out.println();
            System.out.println("실행 결과");
           if(viewer.equals("all")){
                for (Participant iter : participants.getParticipants()) {
                    System.out.println(iter.getName() + " : " + ladderMapping.showResult(iter));
                }
                continue;
            }
            System.out.println(ladderMapping.showResult(new Participant(viewer)));
        }
    }
}
