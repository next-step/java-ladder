package nextstep.ladder.ui;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.util.StringUtils;

public class ResultView {
    private static final String GAME_RESULT_HEADER = "\n실행결과\n";

    private ResultView() {
        throw new UnsupportedOperationException("인스턴스를 생성할 수 없습니다.");
    }

    public static void printGameResult(LadderGame ladderGame) {
        printHeader();
        printPlayers(ladderGame);
        printLadderMap(ladderGame);
    }

    private static void printHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    private static void printLadderMap(LadderGame ladderGame) {
        StringBuilder builder = new StringBuilder();
        ladderGame.getLadder().getMap().forEach(bar -> {
            bar.getRow().forEach(character -> {
                builder.append(character);
                builder.append("|");
            });
            builder.append("\n");
        });
        System.out.println(builder);
    }

    private static void printPlayers(LadderGame ladderGame) {
        StringBuilder builder = new StringBuilder();
        ladderGame.getPlayers().getUsers().forEach(player ->
                builder.append(StringUtils.lPad(player.getName(),6)));
        System.out.println(builder);
    }
}
