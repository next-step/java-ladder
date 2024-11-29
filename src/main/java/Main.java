public class Main {
    public static void main(String[] args) {
        String[] names = InputView.askUserNames();
        int ladderHeight = InputView.askLadderHeight();

        Ladder ladder = (new LadderBuilder(new RandomGenerator())).build(names, ladderHeight);

        ResultView.printResult(ladder);
    }
}
