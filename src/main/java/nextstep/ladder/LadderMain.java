package nextstep.ladder;

public class LadderMain {
    public static void main(String[] args) {
        Person person = new Person(InputView.inputPerson());
        int height = InputView.inputLadderHeight();

        LadderFactory ladderFactory = new RandomLadderFactory();
        Ladder ladder = ladderFactory.creatLadder(height, person.countPerson());

        OutputView.outputResult(person, ladder);
    }
}
