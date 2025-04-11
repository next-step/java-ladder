package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Participant;

import java.util.List;

public class ConsoleOutputView implements OutputViewInterface {
    @Override
    public void printPrompt(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public void printNames(List<Participant> names) {
        names.forEach(name -> System.out.printf("%6s", name.toString()));
        System.out.println();
    }

    @Override
    public void printLadder(List<LadderLine> ladder) {
        ladder.forEach(ladderLine -> {
            System.out.print("     |");
            ladderLine.getBridgeStatus().forEach(bridge -> {
                System.out.print(bridge.toString() + "|");
//                if (bridge.isConnected()) {
//                    System.out.print("-----|");
//                    return;
//                }
//                System.out.print("     |");
            });
            System.out.println();
        });
    }
}
