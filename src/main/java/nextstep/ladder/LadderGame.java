package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private static final String NAME_REX_PATTERN = ",";

    private List<Player> playerList = new ArrayList<>();

    private List<Line> lineList;
    private Ladder ladder;

    public String inputPlayers() {
        return InputView.inputPlayers();
    }

    public void addPlayers(String players) {
        Arrays.stream(players.split(NAME_REX_PATTERN))
                .map(Player::new)
                .forEach(playerList::add);
    }

    public int inputLadderHeight() {
        return InputView.inputLadderHeight();
    }

    public void saveLadder(int height) {
        this.ladder = new Ladder(height, playerList.size());
    }

    public void addLine() {
        lineList = IntStream.range(0, ladder.getHeight())
                .mapToObj(i -> new Line(ladder.getWidth()))
                .collect(Collectors.toList());
    }

    public void printResultText() {
        ResultView.printResultText();
    }

    public void printPlayerName() {
        ResultView.printPlayerName(playerList);
        System.out.println();
    }

    public void printLadderLine() {
        lineList.forEach(ResultView::printLadderLine);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
