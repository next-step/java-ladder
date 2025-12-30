package nextstep.ladder.view;


import nextstep.ladder.domain.ladder.LadderResults;

public class ResultView {

    public static final String NAME_ALL = "all";
    public static final String RESULT_MESSAGE = "[실행결과]";
    public static final String NEXT_LINE = System.lineSeparator();


    public static void resultPeople(LadderResults results, String name) {
        if (name.equalsIgnoreCase(NAME_ALL)) {
            printAll(results);
            return;
        }
        printUserReward(results, name);
    }

    private static void printUserReward(LadderResults results, String name) {
        results.getResults().stream()
                .filter(result -> result.getUserValue().equals(name))
                .findFirst()
                .ifPresent(result -> System.out.println(result.getRewardValue() + NEXT_LINE));
    }

    private static void printAll(LadderResults results) {
        System.out.println(NEXT_LINE + RESULT_MESSAGE);
        results.getResults().forEach(result -> System.out.println(result.getUserValue() + " : " + result.getRewardValue()));
    }
}
