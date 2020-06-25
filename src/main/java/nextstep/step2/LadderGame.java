package nextstep.step2;

public class LadderGame {

    public static void main(String[] args) {
        People people = InputView.inputNames();
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(people.getSize(), height);
        OutputView.draw(ladder, people);
    }
}
