package ladder_v2.view;

import ladder_v2.domain.*;
import java.util.List;


public class OutputView {

    private static final String RESULT_FORMAT = "%6s";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String GAME_RESULT = "실행 결과";
    public static final String ALL = "all";
    public static final String FINAL_RESULT_FORMAT = "%s : %s";
    public static final String LINK = "-----";
    public static final String POLL = "|";
    public static final String UN_LINK = "     ";


    public static void printLadderResult(Players names, Ladder ladder, Rewards rewards) {
        System.out.println(LADDER_RESULT);
        names.names().forEach(name -> System.out.printf(RESULT_FORMAT, name.name()));

        ladderPrint(ladder);

        System.out.println();
        rewards.rewards().forEach(reward -> System.out.printf(RESULT_FORMAT, reward));

    }

    private static void ladderPrint(Ladder ladder) {
        ladder.lines().forEach(OutputView::eachLinePrint);
    }

    private static void eachLinePrint(Line line) {
        System.out.println();
        System.out.printf(RESULT_FORMAT,POLL);
        List<Point> points = line.points();
        eachPointPrint(points);
    }

    private static void eachPointPrint(List<Point> points) {
        for(int i = 0; i< points.size()-1; i++){
            if(points.get(i).isRight()){
                printLink();
                continue;
            }
            printUnLink();
        }
    }

    private static void printUnLink() {
        System.out.print(UN_LINK);
        System.out.print(POLL);
    }

    private static void printLink() {
        System.out.print(LINK);
        System.out.print(POLL);
    }


    public static void printFinalResult(Name name, GameResult result) {
        System.out.println(GAME_RESULT);
        if(name.name().equals(ALL)){
            printAll(result);
            return;
        }
        System.out.printf(FINAL_RESULT_FORMAT,name.name(), result.result().get(name.name()));
    }

    private static void printAll(GameResult result) {
        result.result().forEach((key, value)-> {
            System.out.println();
            System.out.printf(FINAL_RESULT_FORMAT,key,value);
        });
    }

}
