package nextstep.ladder;

public class LadderMain {
    public static void main(String[] args) {
         Person person = new Person(InputView.inputPerson());
         int height = InputView.inputLadderHeight();
         Ladder ladder = new Ladder(height, person.countPerson());

         OutputView.outputResult(person, ladder);
    }
}
