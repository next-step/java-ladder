package ladder;

import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = InputView.inputNames(scanner);
        Players players = new Players(names);
        int height = InputView.inputHeight(scanner);

        LadderGenerator ladderGenerator = new RandomLadderGenerator();
        LadderGame ladderGame = new LadderGame(ladderGenerator, players, height);

        OutputView.print(ladderGame);
    }
}
