package nextstep.ladder;

import nextstep.ladder.input.Input;
import nextstep.ladder.input.UserNames;

public class Main {
    public static void main(String[] args) {
        UserNames userNames = Input.inputNames();
        
        System.out.println("userNames = " + userNames);
    }
}
