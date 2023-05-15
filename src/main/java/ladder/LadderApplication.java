package ladder;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        while(isGameThrowException()){}
    }

    private static boolean isGameThrowException() {
        try {
            playLadderGame();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private static void playLadderGame() throws IllegalArgumentException {
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
    }

}
