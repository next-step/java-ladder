package laddergame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static laddergame.ApplicationLauncher.ALL;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest extends BaseDomainTest {

    @Test
    public void getGameResult_for_one_line_with_two_points1() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_one_line_with_two_points2() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }


    @Test
    public void getGameResult_for_one_line_with_three_points1() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE, FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1),
                        Arrays.asList(2, 2)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }


    @Test
    public void getGameResult_for_one_line_with_three_points2() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE, FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0),
                        Arrays.asList(2, 2)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_one_line_with_three_points3() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE, TRUE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 2),
                        Arrays.asList(2, 1)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_two_points1() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE),
                        Arrays.asList(FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_two_points2() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE),
                        Arrays.asList(FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_two_points3() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE),
                        Arrays.asList(TRUE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_two_points4() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE),
                        Arrays.asList(TRUE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_three_points1() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE, FALSE),
                        Arrays.asList(FALSE, FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1),
                        Arrays.asList(2, 2)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_three_points2() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE, FALSE),
                        Arrays.asList(FALSE, FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0),
                        Arrays.asList(2, 2)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_three_points3() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE, FALSE),
                        Arrays.asList(TRUE, FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1),
                        Arrays.asList(2, 2)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_three_points4() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(TRUE, FALSE),
                        Arrays.asList(FALSE, TRUE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 2),
                        Arrays.asList(1, 0),
                        Arrays.asList(2, 1)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_three_points5() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE, TRUE),
                        Arrays.asList(TRUE, FALSE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 2),
                        Arrays.asList(2, 0)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }

    @Test
    public void getGameResult_for_two_lines_with_three_points6() {
        EndPoints participants = getEndPoints(Arrays.asList("a", "b", "c"));
        EndPoints rewards = getEndPoints(Arrays.asList("0", "100", "1000"));
        LadderLines ladderLines = getLadderLines(
                Arrays.asList(
                        Arrays.asList(FALSE, TRUE),
                        Arrays.asList(FALSE, TRUE)
                )
        );
        Result actual = LadderGame.play(participants, ladderLines, rewards);

        Map<EndPoint, EndPoint> gameResult = getGameResult(
                participants,
                rewards,
                Arrays.asList(
                        Arrays.asList(0, 0),
                        Arrays.asList(1, 1),
                        Arrays.asList(2, 2)
                )
        );
        Result expected = new Result(null, gameResult);

        assertThat(expected.getGameResult(ALL)).isEqualTo(actual.getGameResult(ALL));
    }
}