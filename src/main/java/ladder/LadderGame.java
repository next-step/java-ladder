package ladder;

import ladder.line.LineGenerateStrategy;
import ladder.line.Lines;
import ladder.name.Name;
import ladder.name.Names;
import ladder.view.*;

import java.util.List;
import java.util.Map;

public class LadderGame {
    public static final String EXIT = "exit";

    private final InputView inputView;
    private final ResultView resultView;
    private final LineGenerateStrategy lineGenerateStrategy;

    public LadderGame(InputView inputView, ResultView resultView, LineGenerateStrategy lineGenerateStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lineGenerateStrategy = lineGenerateStrategy;
    }

    public void run() {

        Names names = new Names(inputView.getPlayerNamesFromUser());

        List<String> bettingsFromUser = inputView.getBettingsFromUser();
        Bettings bettings = new Bettings(bettingsFromUser);
        validateSize(names, bettings);

        Height height = new Height(inputView.getHeightFromUser());
        Lines lines = new Lines(names, height, lineGenerateStrategy);
        LadderResult ladderResult = new LadderResult(names, lines.movePoints());

        resultView.showNames(names);
        resultView.showLines(lines);
        resultView.showBettings(bettings);

        String nameFromUser = null;
        while (tryNext(nameFromUser)) {
            nameFromUser = inputView.getNameForResultFromUser();
            Name user = new Name(nameFromUser);

            Map<String, String> bettingResult = ladderResult.getBettingResult(user, bettings);
            resultView.showBettingResult(bettingResult);
        }
    }

    private void validateSize(Names names, Bettings bettings) {
        if(names.hasDifferentSize(bettings.getBettingSize())) {
            throw new IllegalArgumentException("참여자와 실행 결과의 수가 동일해야합니다.");
        }
    }

    private boolean tryNext(String input) {
        return !EXIT.equals(input);
    }
}
