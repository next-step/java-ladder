package ladder.View;


import ladder.Domain.LadderMap;

import java.util.List;

public class OutputView {

    private static String CREATE_MAP_RESULT_INFOMATION = "실행결과";
    private static int PADDING_LENGTH = 5;

    private OutputView() {
    }

    public static OutputView of() {
        return new OutputView();
    }

    public void printUsersName(List<String> climberNames) {
        System.out.println(CREATE_MAP_RESULT_INFOMATION);
        climberNames.forEach(climberName -> {
            System.out.print(lpadString(climberName, PADDING_LENGTH, " ") + " ");
        });
        System.out.println();
    }

    private String lpadString(String text, int length, String alternate) {
        if(text.length() - length >= 0) {
            return text;
        }

        StringBuilder lpadString = new StringBuilder(text);
        int alternateLength = length - text.length();
        for (int i = 0; i < alternateLength; i++) {
            lpadString.insert(0, alternate);
        }
        return lpadString.toString();
    }

    public void printLadderMap(LadderMap ladderMap) {
        ladderMap.toList().forEach(line -> {
            System.out.print("    |");
            line.toList().stream().forEach(cross -> {
                System.out.print(ladderGap(cross));;
            });
            System.out.println();
        });
    }

    private String ladderGap(boolean crossLoad) {
        if (crossLoad) {
           return "----|";
        }
        return "    |";
    }

}
