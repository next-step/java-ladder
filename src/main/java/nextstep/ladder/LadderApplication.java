package nextstep.ladder;

public class LadderApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        PersonNames personNames = new PersonNames(inputNames);
        int inputHeight = InputView.inputHeight();
        Ladder ladder = new Ladder(personNames.size() - 1, inputHeight, new RandomLine());
        OutputView.printLadder(personNames, ladder);
    }
}
