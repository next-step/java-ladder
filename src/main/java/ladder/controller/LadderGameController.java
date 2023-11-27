package ladder.controller;

import ladder.view.LadderRenderer;
import ladder.view.NameRenderer;
import ladder.view.Prompt;
import ladder.view.MessageRenderer;
import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.util.LadderGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderGameController {
    private static final int NAME_WIDTH = 6;

    private Ladder ladder;
    private int depth;
    private final List<Name> names;

    public LadderGameController() {
        this.ladder = null;
        this.names = new ArrayList<>();
    }

    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController();
        gameController.play();
    }

    public void play() {
        init();

        userInputPhase();
        ladderGenerationPhase();
        printPhase();
    }

    private void init() {
        this.ladder = null;
        this.depth = 0;
        this.names.clear();
    }

    private void userInputPhase() {
        String namesString = Prompt.askString("참여할 사람 이름을 입력하세요. (이름은 쉼표 `,`로 구분하세요.)");
        this.names.addAll(Names.of(namesString));

        this.depth = Prompt.askInt("최대 사다리 높이는 몇 개인가요?");
    }

    private void ladderGenerationPhase() {
        this.ladder = LadderGenerator.generateRandomLadder(this.names.size(), depth);
    }

    private void printPhase() {
        MessageRenderer.simplePrint("실행 결과");

        NameRenderer.printNames(this.names, NAME_WIDTH);
        LadderRenderer.printLadder(ladder);
    }

}