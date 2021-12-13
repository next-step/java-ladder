package nextstep.ladder.view;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;
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

    public static void print(Line line){
        print(line.toString());
    }
    public static void print(Lines lines) {
        print(lines.toString());
    }
}
