package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.line.Line;
import ladder.line.RandomLine;
import ladder.view.InputView;
import ladder.view.PrintView;

public class LadderController {

    public void start() {
        Ladder ladder = null;
        Rewards rewards = null;

        Boolean flag = false;
        while (!flag) {
            List<String> names = InputView.getNames();
            List<String> rewardList = InputView.getRewards();

            ladder = getLadder(names, getHeight());
            rewards = getRewards(rewardList, names.size());

            flag = updateFlag(ladder, rewards);
        }

        PrintView.printLadder(ladder, rewards);
    }

    private Boolean updateFlag(Ladder ladder, Rewards rewards) {
        if (ladder != null && rewards != null) {
            return true;
        }
        return false;
    }

    private int getHeight() {
        try {
            return InputView.getHeight();
        } catch (Exception e) {
            return 0;
        }
    }

    private Ladder getLadder(List<String> names, int height) {
        try {
            return initLadder(names, height);
        } catch (Exception e) {
            printTryAgain(e);
            return null;
        }
    }

    private Rewards getRewards(List<String> rewardsList, int countOfPerson) {
        try {
            return new Rewards(rewardsList, countOfPerson);
        } catch (Exception e) {
            printTryAgain(e);
            return null;
        }
    }

    private Ladder initLadder(List<String> names, int height) {
        Ladder ladder = new Ladder(names, height);
        addLadder(ladder, names.size(), height);
        return ladder;
    }

    private void addLadder(Ladder ladder, int countOfPerson, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> new RandomLine(countOfPerson))
                .collect(Collectors.toUnmodifiableList());
        ladder.addLines(lines);
    }

    private void printTryAgain(Exception e) {
        PrintView.printError(e);
        PrintView.printTryAgain();
        InputView.clear();
    }

}
