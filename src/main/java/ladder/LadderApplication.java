package ladder;

public class LadderApplication {

    public static void main(String[] args) {
        while(!isEnd()){}
    }

    private static boolean isEnd() {
        try {
            InputView.askNames();
            String input = InputView.nextString();
            Names names = Names.of(input);

            InputView.askHeight();
            int height = InputView.nextInt();
            Ladder ladder = Ladder.of(height, names.count() - 1);

            int width = names.properWidth();

            OutputView.printResult();
            OutputView.printNames(names, width);
            OutputView.printLadder(ladder, width * 2);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
