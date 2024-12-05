public class Main {
    public static void main(String[] args) {
        String[] names = InputView.askUserNames();
        String[] resultNames = InputView.askResultNames();
        int ladderHeight = InputView.askLadderHeight();

        Ladder ladder = (new LadderBuilder(new RandomGenerator())).build(names, resultNames, ladderHeight);

        ResultView.printLadder(ladder);

        String playerName = "";

        InputView.flush();

        while(!playerName.equals("all")) {
            playerName = InputView.askPlayerName();

            ResultView.printResults(ladder, playerName);
        }
    }
}
