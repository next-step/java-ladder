package ladder;

public class OutputView {

    private final String RESULT = "실행결과";

    public void showResult(Players players, Height height) {
        System.out.println(RESULT);

        players.showPlayerNames();

        for (int i = 0; i < height.getHeight(); i++) {
            for (int j = 0; j < players.getSize(); j++) {
                System.out.print("|");
                System.out.print("-----");
            }
            System.out.println("");
        }
    }

    public void showLadder(Ladder ladder, Players players) {
        System.out.println(RESULT);

        players.showPlayerNames();

        ladder.showLadder();
    }
}
