package ladder;

public class LadderMain {
    public static void main(String[] args) {
        Persons persons = new Persons(InputView.inputPersonNames());
        Results results = new Results(InputView.inputPlayResults());
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, persons.countOfPersons(), new HorizontalLineRandomStrategy());

        OutputView.printLadder(persons, ladderHeight, ladder, results);

        LadderPlayer ladderPlayer = new LadderPlayer(persons, results);
        String name = InputView.inputResultName();
        OutputView.printResult(ladderPlayer.getResultOf(name, ladder));
    }

}
