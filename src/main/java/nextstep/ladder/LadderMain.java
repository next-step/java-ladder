package nextstep.ladder;

public class LadderMain {
    public static void main(String[] args) {
         Person person = new Person(InputView.inputPerson());
         Line line = new Line(InputView.inputLadderHeight());

         OutputView.outputLadder(person, line);

    }
}
