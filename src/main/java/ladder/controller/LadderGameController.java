package ladder.controller;

import ladder.domain.*;
import ladder.domain.generator.RandomLadderLineGenerator;
import ladder.view.*;

import java.util.ArrayList;
import java.util.List;

public class LadderGameController {
    private static final int NAME_WIDTH = 6;

    private LadderGame ladderGame;
    private int depth;
    private final List<Name> names;
    private final List<ResultItem> resultItems;

    public LadderGameController() {
        this.ladderGame = null;
        this.names = new ArrayList<>();
        this.resultItems = new ArrayList<>();
    }

    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController();
        gameController.play();
    }

    public void play() {
        init();

        userInitPhase();
        ladderGenerationPhase();
        getResultPhase();
    }

    private void init() {
        this.ladderGame = null;
        this.depth = 0;
        this.names.clear();
        this.resultItems.clear();
    }

    private void userInitPhase() {
        String namesString = Prompt.askString("참여할 사람 이름을 입력하세요. (이름은 쉼표 `,`로 구분하세요.)");
        this.names.addAll(Names.of(namesString));

        String resultString = Prompt.askString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        this.resultItems.addAll(ResultItems.of(resultString));

        this.depth = Prompt.askInt("최대 사다리 높이는 몇 개인가요?");
    }

    private void ladderGenerationPhase() {
        Ladder ladder = Ladder.of(new RandomLadderLineGenerator(this.names.size()), depth);
        this.ladderGame = new LadderGame(this.names, ladder, this.resultItems);

        NameRenderer.printNames(this.ladderGame.names(), NAME_WIDTH);
        LadderRenderer.printLadder(this.ladderGame.ladderBody());
        ResultRenderer.printResult(this.ladderGame.results(), NAME_WIDTH);
    }

    private void getResultPhase() {

        String name = Prompt.askString("결과를 보고 싶은 사람은?");

        MessageRenderer.simplePrint("실행 결과");
        if (name.equals("all")) {
            LadderResultSet resultSet = this.ladderGame.calculateResultsOfAll();
            LadderResultSetRenderer.printSet(resultSet);
            return;
        }

        LadderResult ladderResult = this.ladderGame.calculateResultOf(new Name(name));
        LadderResultSetRenderer.printSingleResult(ladderResult);
    }
}