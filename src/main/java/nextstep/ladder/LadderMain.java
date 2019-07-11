package nextstep.ladder;

public class LadderMain {
    public static void main(String[] args) {

        String[] userNames = Input.getUsers();
        Users users = Users.of(userNames);
        String[] rewardNames = Input.getResults(users.count());
        Rewards rewards = Rewards.of(rewardNames);

        Ladder ladder = new Ladder(Input.getMaxHeight(), users.count(), new RandomBooleanFunction());

        Output.printLadder(users, ladder, rewards);

        MatchingResult matchingResult = ladder.play();
        LadderResult ladderResult = matchingResult.map(users, rewards);

        String inputResult;
        while (!(inputResult = Input.getInputResult()).equals("all")) {
            final String userName = inputResult;
            Output.printResultByUserName(ladderResult, userName);
        }

        Output.printResult(ladderResult);

    }
}
