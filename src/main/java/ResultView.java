import java.util.List;

public class ResultView {
    public static void printV(Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println(ladder);
    }

    public static void printResults(Ladder ladder, String playerName) {
        if (playerName.equals("all")) {
            printTravelAll(ladder);
        } else {
            printTravel(ladder, playerName);
        }
    }

    private static void printTravelAll(Ladder ladder) {
        List<TravelResult> travelResults = ladder.travelAll();

        for (TravelResult travelResult : travelResults) {
            printMoveResult(travelResult);
        }
    }

    private static void printTravel(Ladder ladder, String playerName) {
        TravelResult travelResult = ladder.travel(playerName);

        printMoveResult(travelResult);
    }

    private static void printMoveResult(TravelResult travelResult) {
        System.out.println(travelResult);
    }
}
