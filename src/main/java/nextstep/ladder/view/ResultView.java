package nextstep.ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Lines;

public class ResultView {

    public static void printPlayerNames(List<String> playerNames) {
        playerNames.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printLadders(Lines lines) {
        List<String> printString = new ArrayList<>();

        for (int i = 0; i < lines.getHeight(); i++) {
            printString.add(
                "     |" + lines.getExists(i).stream()
                .map(e -> {
                    if (e) {
                        return "-----";
                    }

                    return "     ";
                }).collect(Collectors.joining("|")) + "|");
        }

        printString.forEach(System.out::println);
    }
}
