package nextstep.ladder.fixture;

import nextstep.ladder.domain.endpoint.Endpoints;
import nextstep.ladder.domain.laddar.LadderColumn;
import nextstep.ladder.domain.laddar.LadderGameContext;
import nextstep.ladder.domain.laddar.LadderSize;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.strategy.DirectionStrategy;

/**
 * 테스트를 위한 픽스처를 정의한다.
 */
public class LadderFixture {
    public static final String INPUT_PLAYER_NAMES_FIXTURE = "pobi,honux,crong,jk";
    public static final String INPUT_ENDPOINTS_FIXTURE = "꽝,5000,꽝,3000";

    public static final int WIDTH_SIZE_FIXTURE = 5;
    public static final int HEIGHT_SIZE_FIXTURE = 5;

    public static final Players PLAYERS = Players.from(INPUT_PLAYER_NAMES_FIXTURE);
    public static final Endpoints ENDPOINTS = Endpoints.from(INPUT_ENDPOINTS_FIXTURE);

    public static final DirectionStrategy DIRECTION_TRUE = () -> true;
    public static final DirectionStrategy DIRECTION_FALSE = () -> false;

    public static final LadderSize LADDER_SIZE = LadderSize.of(WIDTH_SIZE_FIXTURE, HEIGHT_SIZE_FIXTURE);
    public static final LadderGameContext LADDER_GAME_CONTEXT = LadderGameContext.of(LADDER_SIZE, DIRECTION_TRUE);

    public static final LadderColumn FIRST_TRUE_COLUMN = LadderColumn.createFirst(LadderFixture.DIRECTION_TRUE);
    public static final LadderColumn FIRST_FALSE_COLUMN = LadderColumn.createFirst(LadderFixture.DIRECTION_FALSE);
}
