package ladder.domain;

import java.util.Arrays;
import java.util.List;


public class Fixture {
    public static final String HYERIN = "hyerin";
    public static final String ISISRIN = "isisrin";
    public static final Player HYERIN_PLAYER = new Player(HYERIN);
    public static final Player ISISRIN_PLAYER = new Player(ISISRIN);
    public static final List<String> PLAYER_LIST = Arrays.asList(HYERIN, ISISRIN);

    public static final String LOSE = "밥값내기";
    public static final String WIN = "얻어먹기";
    public static final GameResult LOSE_RESULT = new GameResult(LOSE);
    public static final GameResult WIN_RESULT = new GameResult(WIN);
    public static final List<String> GAME_RESULT_LIST = Arrays.asList(LOSE, WIN);

    public static final PlayResult HYERIN_PLAY_RESULT = new PlayResult(HYERIN_PLAYER, WIN_RESULT);
    public static final PlayResult ISISRIN_PLAY_RESULT = new PlayResult(ISISRIN_PLAYER, LOSE_RESULT);
    public static final List<PlayResult> PLAY_RESULTS_LIST = Arrays.asList(HYERIN_PLAY_RESULT, ISISRIN_PLAY_RESULT);
    public static final PlayResults PLAY_RESULTS = new PlayResults(PLAY_RESULTS_LIST);

    public static final Ladder LADDER = new Ladder(PLAYER_LIST.size(), LEVEL.LOW, GAME_RESULT_LIST);
    public static final LadderGameResult LADDER_GAME_RESULT = new LadderGameResult(PLAY_RESULTS);

    public static final Direction DOUBLE_FALSE = Direction.of(false, false);
    public static final Point FIRST_POINT = new Point(0, Direction.of(false, true));
    public static final Point LAST_POINT = new Point(1, Direction.of(true, false));
    public static final Line DISCONNECTED_LINE = new Line(Arrays.asList(LAST_POINT, FIRST_POINT));
    public static final Line CONNECTED_LINE = new Line(Arrays.asList(FIRST_POINT, LAST_POINT));

}
