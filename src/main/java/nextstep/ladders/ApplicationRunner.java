package nextstep.ladders;

import nextstep.ladders.views.ConsoleInputView;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsoleInputView inputView = new ConsoleInputView(scanner);

        String participantsText = inputView.enterParticipants();
        String maxLadderHeightText = inputView.enterMaxLadderHeight();
        
        scanner.close();
    }
}
