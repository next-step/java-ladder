package ladder.view;

import ladder.Model.Ladder;
import ladder.Model.Line;
import ladder.Model.User;
import ladder.Model.Users;

import java.util.stream.Collectors;

public class OutputView {

    private final static String ladderDefaultWidthLine = "-----";
    private final static String ladderTrimWidthLine = "     ";
    private final static String ladderStartWidthLine = "    ";
    private final static String ladderDefaultHeightLine = "|";

    public static void printLadderUser(Users users){
        System.out.println("\n실행 결과\n");
        System.out.println(
                users.getUsers()
                     .stream()
                     .map(User::getName)
                     .collect(Collectors.joining(" "))
        );
    }

    public static void printLadder(Ladder ladder){
        for(Line line : ladder.getLadder()){
            printDrawLine(line);
        }
    }

    static void printDrawLine(Line line){
        StringBuilder ladderLine = new StringBuilder();
        ladderLine.append(ladderStartWidthLine);
        ladderLine.append(ladderDefaultHeightLine);
        ladderLine.append(
                line.getPoints()
                    .stream()
                    .map(point -> lineText(point))
                    .collect(Collectors.joining(ladderDefaultHeightLine))
        );
        ladderLine.append(ladderDefaultHeightLine);
        System.out.println(ladderLine.toString());
    }

    static String lineText(boolean line){
        if(line){
            return ladderDefaultWidthLine;
        }
        return ladderTrimWidthLine;
    }

}
