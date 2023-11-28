package ladder.view;

import java.util.List;

import ladder.domain.data.PersonNames;

public class ResultView {

    public static void personNames(PersonNames personNames) {
        System.out.println("\n실행결과\n");
        System.out.println(personNames);
    }

    public static void result(List<?> collections) {
        collections.forEach(System.out::println);
    }

}
