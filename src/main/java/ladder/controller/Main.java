package ladder.controller;

import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(InputView.getParticipantInputText());
        String nameString = scanner.nextLine();

        System.out.println(InputView.getLadderHeightInputText());
        int ladderHeight = scanner.nextInt();

        Names names = Names.of(nameString);

        // TODO: Ladder 생성시 사다리가 인접하지 않게 생성되도록 구현한다.
        // Ladder ladder = new Ladder(names.size(), ladderHeight);

        System.out.println(ResultView.getDefaultResultText());
        System.out.println(ResultView.getNamesView(names));
//        System.out.println(ResultView.getLadderView(ladder));
    }
}
