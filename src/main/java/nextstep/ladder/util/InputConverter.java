package nextstep.ladder.util;

import nextstep.ladder.model.People;

public class InputConverter {

    private InputConverter() {
    }

    public static String[] splitWithComma(String input){
        return input.split(",");
    }
}
