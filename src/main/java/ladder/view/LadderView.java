package ladder.view;

import ladder.domain.Gamer;
import ladder.domain.Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderView {
    private static final String GAMER_NAME_GUIDE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_GUIDE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String RUN_RESULT = "\n실행결과\n";
    private static final String LADDER_FOOTHOLD_SYMBOL = "-";
    private static final String EMPTY_SYMBOL = " ";
    private static final String LADDER_HEIGHT_SYMBOL = "|";

    public void printGamerNameGuide() {
        printGuideStr(GAMER_NAME_GUIDE);
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printLadderHeightGuide() {
        printGuideStr(LADDER_HEIGHT_GUIDE);
    }

    public void printRunResultGuide() {
        printGuideStr(RUN_RESULT);
    }

    private <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private <T> void forEach(List<T> list, Consumer<T> consumer) {
        for(T t: list) {
            consumer.accept(t);
        }
    }

    public void printGamer(Gamer gamer) {
        List<String> resultNames = gamer.getNames().stream()
                .map(t -> {
                    for (int i=t.length(); i < Gamer.MAX_GAMER_NAME_LENGTH; i++) {
                        t = EMPTY_SYMBOL + t;
                    }
                    return t;
                })
                .collect(Collectors.toList());

        forEach(resultNames, (String s) -> System.out.print(s+EMPTY_SYMBOL));
        printGuideStr("");
    }

    private String footHoldString(FootholdStrategy footholdStrategy) {
        String footHold = "";
        String symbol = "";
        if (footholdStrategy.isVisble()) {
            symbol = LADDER_FOOTHOLD_SYMBOL;
        }
        if (!footholdStrategy.isVisble()) {
            symbol = EMPTY_SYMBOL;
        }
        for (int index = 0; index < Gamer.MAX_GAMER_NAME_LENGTH; index++) {
            footHold += symbol;
        }
        return footHold;
    }

    public void printLadder(Ladder ladder) {
        ladder.getLines().stream()
                .map(line -> line.getPoints().stream()
                        .map(point -> footHoldString(() -> point))
                        .reduce(footHoldString(() -> false) , (s1, s2) -> s1 +  LADDER_HEIGHT_SYMBOL + s2))
                .forEach(System.out::println);
    }

    private void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }
}
