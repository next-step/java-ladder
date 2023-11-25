package nextstep.ladder;

public class LadderApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        PersonNames personNames = new PersonNames(inputNames);
    }
}
