package ladder.View;


import ladder.Domain.LadderMap;

public class OutputView {

    private static String CREATE_MAP_RESULT_INFOMATION = "실행결과";

    private OutputView() {
    }

    public static OutputView of() {
        return new OutputView();
    }

    public void printLadderMap(LadderMap ladderMap) {
        System.out.println(CREATE_MAP_RESULT_INFOMATION);

        ladderMap.toList().forEach(line -> {
            System.out.print("|");
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
