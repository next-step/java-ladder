package nextstep.ladder;

import nextstep.ladder.view.InputView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] people = inputView.inputPeople();
        int height = inputView.inputMaxLadderHeight();
        System.out.println("people = " + Arrays.toString(people));
        System.out.println("height = " + height);

        inputView.close();
    }
}
