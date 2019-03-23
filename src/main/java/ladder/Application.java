package ladder;

import ladder.domain.Gamer;
import ladder.domain.Ladder;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        doLadderGame();
    }

    private static void doLadderGame() {
        String inputName = LadderInputView.inputName();

        String[] names = LadderInputView.splitInputName(inputName);

        List<Gamer> gamers = new ArrayList<>();
        Arrays.stream(names).forEach(name -> gamers.add(new Gamer(name)));

        List<Gamer> sortedGamers = new ArrayList<>(gamers);
        sortedGamers.sort(Collections.reverseOrder());
        int maxNameLength = sortedGamers.get(0).getNameLength();

        int height = LadderInputView.inputHeight();
        Ladder ladder = new Ladder(height, gamers.size());
        ladder.checkLadder();

        LadderOutputView.printResult(gamers, maxNameLength, ladder);
    }
}
