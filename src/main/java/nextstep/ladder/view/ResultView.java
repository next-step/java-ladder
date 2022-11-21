package nextstep.ladder.view;

import nextstep.ladder.domain.Names;

public class ResultView {
    public static final int MAX_LENGTH = 5;
    private static StringBuilder builder;

    public static void showName(Names playerNames) {
        builder = new StringBuilder();

        playerNames.names()
            .stream()
            .map(name ->
                builder.append(makeName(name.name())));

        System.out.println(builder);
    }

    private static StringBuilder makeName(String name) {
        StringBuilder builder = new StringBuilder();
        int space = MAX_LENGTH - name.length();

        for (int i = 0; i < space; i++) {
            builder.append(" ");
        }

        builder.append(name);
        return builder;
    }
}
