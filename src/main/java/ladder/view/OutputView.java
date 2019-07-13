package ladder.view;

import ladder.model.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.repeat;


public class OutputView {

    private static final String LADDER_DEFAULT_HEIGHT_LINE = "|";
    private static String ladderDefaultWidthLine = "";
    private static String ladderTrimWidthLine = "";
    private static String ladderStartWidthLine = "";

    public static void printLadderUser(Users users, int maxTextLength){
        outputSepartorInit(maxTextLength);
        System.out.println("\n실행 결과\n");
        System.out.println(
                users.getUsers()
                     .stream()
                     .map(user -> coustomTextLen(user.getName(), maxTextLength))
                     .collect(Collectors.joining(" "))
        );
    }

    public static void printLadder(Ladder ladder){
        for(Line line : ladder.getLadder()){
            printDrawLine(line);
        }
    }

    public static void printResultItem(Result ladderResultItem) {
        int maxLadderTextCount = ladderResultItem.maxLadderTextCount();
        System.out.println(
                ladderResultItem.getResultItem()
                        .stream()
                        .map(item -> coustomTextLen(item, maxLadderTextCount))
                        .collect(Collectors.joining(" "))
        );
    }

    public static void printAllUserReust(List<String> allUsersResult, List<User> userNames) {
        System.out.println("\n실행결과");
        for(int i = 0; i< allUsersResult.size(); i++){
            System.out.println(
                    userNames.get(i).getName()
                             .concat(" : ")
                             .concat(allUsersResult.get(i))
            );
        }
    }

    public static void printUserResult(String userResult) {
        System.out.println("\n실행결과");
        System.out.println(userResult);
    }

    private static String coustomTextLen(String userName, int maxTextLength){
        int scarceSpace = maxTextLength - userName.length();
        return createlineSeparator(scarceSpace, " ").concat(userName);
    }

    private static void printDrawLine(Line line){
        StringBuilder ladderLine = new StringBuilder();
        ladderLine.append(ladderStartWidthLine);
        ladderLine.append(LADDER_DEFAULT_HEIGHT_LINE);
        ladderLine.append(
                line.getPoints()
                    .stream()
                    .map(point -> lineText(point.getStatusOfPoint().isRight()))
                    .collect(Collectors.joining(LADDER_DEFAULT_HEIGHT_LINE))
        );
        System.out.println(ladderLine.toString());
    }

    private static String lineText(boolean line){
        if(line){
            return ladderDefaultWidthLine;
        }
        return ladderTrimWidthLine;
    }

    private static void outputSepartorInit(int maxNameLength){
        ladderDefaultWidthLine = repeat("-", maxNameLength);
        ladderTrimWidthLine = repeat(" ", maxNameLength);
        ladderStartWidthLine = repeat(" ", maxNameLength-1);
    }

    private static String createlineSeparator(int maxNameLength, String separator){
        StringBuilder lineSeparator = new StringBuilder();
        for(int i=0; i<maxNameLength; i++){
            lineSeparator.append(separator);
        }
        return lineSeparator.toString();
    }

}
