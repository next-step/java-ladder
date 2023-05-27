package ladder.view;

import java.util.List;

public class ResultView {
    public static void players(List<String> names) {
        System.out.println(String.join(",", names));
    }
}
