package nextstep.ladder.view;

import nextstep.ladder.Ladder;

import java.util.List;

public class OutputView {

    public static void showResult(Ladder ladder) {

        System.out.println(ladder);
        showNames(ladder.getNames());
    }

    public static void showNames(List<String> names) {
        names.stream().forEach(name -> System.out.print(RPadding(name)));
        System.out.println();
    }

    public static String RPadding(String str) {
        while (str.length() < 6) {
            str += " ";
        }
        return str;
    }
}
