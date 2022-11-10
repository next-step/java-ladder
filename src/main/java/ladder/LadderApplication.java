package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderApplication {
    public static void main (String[] args) {
        play();
    }

    private static void play() {
        ResultView.playersCount();
        String names = InputView.stringInput();
        List<User> players = Arrays.stream( names.split(",")).map(name -> new User(name)).collect(Collectors.toList());

        ResultView.ladderHeight();
        int height = InputView.integerInput();

        ResultView.result(players, generateLadder(height, players.size()));
    }

    private static List<Line> generateLadder(int height, int playersCount) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i ++) {
            ladder.add(new Line(playersCount - 1));
        }

        return ladder;
    }
}
