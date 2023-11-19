package nextstep.ladder;

import nextstep.ladder.input.Input;

public class Main {
    public static void main(String[] args) {
        String userNames = Input.inputNames();
        System.out.println("userNames = " + userNames);
    }
}
