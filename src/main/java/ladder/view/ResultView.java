package ladder.view;

import java.util.Arrays;

public class ResultView {
    private ResultView() {
    }

    public static void printNames(String[] names) {
        Arrays.stream(names)
                .forEach(name -> System.out.print(name + "\t"));
    }


}
