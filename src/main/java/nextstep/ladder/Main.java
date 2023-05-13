package nextstep.ladder;

import nextstep.ladder.view.InputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> people = inputView.inputPeople();
        int height = inputView.inputMaxLadderHeight();
        System.out.println("people = " + people);
        System.out.println("height = " + height);

        inputView.close();
    }
}
