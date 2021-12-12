package nextstep.ladder.view;

import nextstep.ladder.model.Person;

public class OutputView {

    private OutputView() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Person person) {
        print(person.toString());
    }
}
