package ladder.view;

import ladder.model.*;

import java.util.stream.Collectors;

public class OutputView {
    private static final String CONNECT = "-----";
    private static final String DISCONNECT = "     ";
    private static final String COLUMN = "|";

    public static void printLadderGameResult(NameList nameList, Ladder ladder, GameResultList gameResultList) {
        printLadderGameResultTitle(nameList);

        for (Line line : ladder.getLines()) {
            String oneLine = line.getPoints().stream()
                    .map(point -> point ? CONNECT : DISCONNECT)
                    .collect(Collectors.joining(COLUMN, COLUMN, COLUMN));
            System.out.println(oneLine);
        }
        printLadderGameResultBack(gameResultList);

    }


    private static void printLadderGameResultTitle(NameList nameList) {
        System.out.println("실행 결과");

        for (String name : nameList.getNameList()) {
            System.out.print(String.format("%-6s", name));
        }
        System.out.println();
    }

    private static void printLadderGameResultBack(GameResultList gameResultList) {
        System.out.println("실행 결과");

        for (String name : gameResultList.getResultList()) {
            System.out.print(String.format("%-6s", name));
        }
        System.out.println();

    }

    public static void printResultOfGame(GameResult gameResult, String name) {
        System.out.println("실행 결과");
        System.out.println(makeResultOfGame(gameResult, name));
    }

    private static String makeResultOfGame(GameResult gameResult, String name){
        if ("all".equals(name)) {
            return makeAllResult(gameResult);
        }
        return gameResult.makeResult(name);
    }

    private static String makeAllResult(GameResult gameResult) {
        String result = "";
        GameResultList gameResultList = gameResult.getGameResultList();
        NameList nameList = gameResult.getNameList();

        for (int i = 0; i < gameResultList.getResultList().size(); i++) {
            result = result + nameList.getNameList().get(i) + " : " + gameResultList.getResultList().get(i) + "\n";
        }
        return result;
    }
}
