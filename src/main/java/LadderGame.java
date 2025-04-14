import domain.*;
import view.InputView;
import view.OutputView;
import view.ResultMapping;

import java.util.*;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    public static void main(String[] args) {
        // InputView, OutputView는 Input, Output 인터페이스의 구현체
        LadderGameController controller = new LadderGameController(new InputView(), new OutputView());
        controller.run();  // 실행 흐름 위임
    }

    private final PlayerNames playerNames;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(PlayerNames playerNames, Results results, Ladder ladder) {
        this.playerNames = playerNames;
        this.results = results;
        this.ladder = ladder;
    }

    public String play(String playerName) {
        int index = playerNames.indexOf(playerName);
        int finalIndex = ladder.move(index);
        return results.getResultAt(finalIndex);
    }

    public List<String> playAll() {
        List<String> allResults = new ArrayList<>();
        IntStream.range(0, playerNames.size())
                .forEach(i -> {
                    String name = playerNames.getNameAt(i);
                    String result = results.getResultAt(ladder.move(i));
                    allResults.add(name + " : " + result);
                });
        return allResults;
    }
}
