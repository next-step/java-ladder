package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;

import java.util.List;

public class ConsoleOutputView implements OutputViewInterface {
    @Override
    public void printPrompt(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public void printNames(String[] names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    @Override
    public void printLadder(List<LadderLine> ladder) {
        ladder.forEach(ladderLine -> {
            System.out.print("     |");
            ladderLine.getBridgeStatus().forEach(ladderPoint -> {
                if (ladderPoint) {
                    System.out.print("-----|");
                } else {
                    System.out.print("     |");
                }
            });
            System.out.println();
        });
    }
}
