package ladder.view;

import ladder.Model.Ladder;
import ladder.Model.Line;
import ladder.Model.Users;

import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_DEFAULT_HEIGHT_LINE = "|";
    private static String ladderDefaultWidthLine = "";
    private static String ladderTrimWidthLine = "";
    private static String ladderStartWidthLine = "";
    private static int maxUserNameLength = 0;

    public static void printLadderUser(Users users){
        maxUserNameLength = users.getMaxUserNameLength();
        outputSepartorInit(maxUserNameLength);
        System.out.println("\n실행 결과\n");
        System.out.println(
                users.getUsers()
                     .stream()
                     .map(user -> coustomUserNameLen(user.getName()))
                     .collect(Collectors.joining(" "))
        );
    }

    public static void printLadder(Ladder ladder){
        for(Line line : ladder.getLadder()){
            printDrawLine(line);
        }
    }

    private static String coustomUserNameLen(String userName){
        int scarceSpace = maxUserNameLength - userName.length();
        return createlineSeparator(scarceSpace, " ").concat(userName);
    }

    private static void printDrawLine(Line line){
        StringBuilder ladderLine = new StringBuilder();
        ladderLine.append(ladderStartWidthLine);
        ladderLine.append(LADDER_DEFAULT_HEIGHT_LINE);
        ladderLine.append(
                line.getPoints()
                    .stream()
                    .map(point -> lineText(point))
                    .collect(Collectors.joining(LADDER_DEFAULT_HEIGHT_LINE))
        );
        ladderLine.append(LADDER_DEFAULT_HEIGHT_LINE);
        System.out.println(ladderLine.toString());
    }

    private static String lineText(boolean line){
        if(line){
            return ladderDefaultWidthLine;
        }
        return ladderTrimWidthLine;
    }

    private static void outputSepartorInit(int maxNameLength){
        ladderDefaultWidthLine = createlineSeparator(maxNameLength, "-");
        ladderTrimWidthLine = createlineSeparator(maxNameLength, " ");
        ladderStartWidthLine = createlineSeparator(maxNameLength-1, " ");
    }

    private static String createlineSeparator(int maxNameLength, String separator){
        StringBuilder lineSeparator = new StringBuilder();
        for(int i=0; i<maxNameLength; i++){
            lineSeparator.append(separator);
        }
        return lineSeparator.toString();
    }

}
