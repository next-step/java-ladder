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


        System.out.println(ResultView.getDefaultResultText());
        System.out.println(ResultView.getNamesView(names));
    }
}
