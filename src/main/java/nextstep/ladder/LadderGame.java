package nextstep.ladder;

import nextstep.ladder.model.*;
import nextstep.ladder.utils.StringUtils;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {

    private LadderGame() {
    }

    public static void main(String[] args) {

        Players players = InputView.createPlayers();
        Results results = InputView.createResults(players.size());
        Lines lines = InputView.createLines(players.size());

        Ladder ladder = new Ladder(players, lines, results);
        OutputView.print(ladder);

        Report report = ladder.game();

        String name = InputView.nextLine("결과를 보고 싶은 사람은?");
        if ("all".equals(StringUtils.validationNotNullAndEmpty(name))) {
            OutputView.print(report);
        } else {
            OutputView.print(report, name);
        }
    }
}
