package ladder.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void getResultHeader() {
        System.out.println("실행결과");
    }

    public static String getPoint(boolean value) {
        return value ? "-" : " ";
    }

    public static String showPlayers(String[] players) {
        return Arrays.stream(players)
                .map(ResultView::adjustGap)
                .collect(Collectors.joining());
    }

    public static String adjustGap(String input){
        return " ".repeat(6-input.length()).concat(input);
    }
}
