package ladder.view;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String INTRO = "\n실행 결과\n";
    private static final String NAMES_DELIMITER = " ";
    private static final int FIXED_NAME_LENGTH = 5;

    public static void printIntro() {
        System.out.println(INTRO);
    }

    /**
     * pobi  honux crong   jk
     *     |-----|     |-----|
     *     ...
     */
    public static void printNames(List<String> names) {
        String allNames = names.stream()
                .map(ResultView::fixedName)
                .collect(joining(NAMES_DELIMITER));

        System.out.println(allNames);
    }

    public static void printLadders(Integer personCount, Integer height) {
        for (int i = 0; i < height; i++) {
            System.out.println("    |" + "     |".repeat(personCount - 1));
        }
    }

    private static String fixedName(String name) {
        int nameLength = name.length();
        if (nameLength == FIXED_NAME_LENGTH) {
            return name;
        }

        return  " ".repeat(FIXED_NAME_LENGTH - 1 - nameLength) + name + " ";
    }
}
