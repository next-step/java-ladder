package laddergame.domain;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static laddergame.ApplicationLauncher.ALL;
import static org.junit.Assert.assertEquals;

public class ResultTest {

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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
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

        assertEquals(expected.getGameResult(ALL), actual.getGameResult(ALL));
    }

    private LadderLines getLadderLines(List<List<Boolean>> linksPerLine) {

        List<LadderLine> ladderLines = new ArrayList<>();

        for(List<Boolean> curLine : linksPerLine) {
            List<Point> points = new ArrayList<>();

            if( curLine.size() > 0 ) {
                points.add(new Point(0, Direction.of(FALSE, curLine.get(0))));

                for (int i = 1; i < curLine.size(); ++i) {
                    points.add(new Point(i, Direction.of(curLine.get(i - 1), curLine.get(i))));
                }

                points.add(new Point(curLine.size(), Direction.of(curLine.get(curLine.size() - 1), FALSE)));
            }
            ladderLines.add(new LadderLine(points));
        }

        return new LadderLines(ladderLines);
    }

    private EndPoints getEndPoints(List<String> names) {
        return new EndPoints(
            IntStream.range(0, names.size())
                    .mapToObj(i -> new EndPoint(names.get(i), i))
                    .collect(Collectors.toList())
        );
    }

    private Map<EndPoint, EndPoint> getGameResult(EndPoints participants, EndPoints rewards, List<List<Integer>> pointIndexPairs) {

        Map<EndPoint, EndPoint> gameResult = new LinkedHashMap<>();

        for( List<Integer> curIndexPair : pointIndexPairs ) {
            gameResult.put(participants.getEndPoint(curIndexPair.get(0)), rewards.getEndPoint(curIndexPair.get(1)));
        }

        return gameResult;
    }
}