package laddergame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static laddergame.ApplicationLauncher.ALL;
import static org.junit.Assert.assertEquals;

public class LadderGameResultTest {

    @Test
    public void getRewardResultStrings_for_switched_two_points_one_line() {
        EndPoints participants = getEndPoints(
            Arrays.asList(
                new EndPoint("a", 0),
                new EndPoint("b", 1)
            )
        );

        EndPoints rewards = getEndPoints(
            Arrays.asList(
                new EndPoint("1000", 0),
                new EndPoint("0", 1)
            )
        );

        LadderLines oneLadderLines = getOneLadderLines(TRUE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(0));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_unswitched_two_points_one_line() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("1000", 0),
                        new EndPoint("0", 1)
                )
        );

        LadderLines oneLadderLines = getOneLadderLines(FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }


    @Test
    public void getRewardResultStrings_for_unswitched_three_points_one_line() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getOneLadderLines(FALSE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(2));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }


    @Test
    public void getRewardResultStrings_for_switched_three_points_one_line1() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getOneLadderLines(TRUE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(2));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_switched_three_points_one_line2() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getOneLadderLines(FALSE, TRUE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(2));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(1));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_two_points1() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(FALSE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_two_points2() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(TRUE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(0));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_two_points3() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(FALSE, TRUE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(0));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_two_points4() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(TRUE, TRUE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_three_points1() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(FALSE, FALSE, FALSE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(2));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_three_points2() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(TRUE, FALSE, FALSE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(2));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_three_points3() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(TRUE, FALSE, TRUE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(2));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_three_points4() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(TRUE, FALSE, FALSE, TRUE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(2));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(1));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_three_points5() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(FALSE, TRUE, TRUE, FALSE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(2));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(0));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    @Test
    public void getRewardResultStrings_for_two_lines_with_three_points6() {
        EndPoints participants = getEndPoints(
                Arrays.asList(
                        new EndPoint("a", 0),
                        new EndPoint("b", 1),
                        new EndPoint("c", 2)
                )
        );

        EndPoints rewards = getEndPoints(
                Arrays.asList(
                        new EndPoint("0", 0),
                        new EndPoint("100", 1),
                        new EndPoint("1000", 2)
                )
        );

        LadderLines oneLadderLines = getTwoLadderLines(FALSE, TRUE, FALSE, TRUE);

        Map<EndPoint, EndPoint> switchedMap = new LinkedHashMap<>();
        switchedMap.put(participants.getEndPoint(0), rewards.getEndPoint(0));
        switchedMap.put(participants.getEndPoint(1), rewards.getEndPoint(1));
        switchedMap.put(participants.getEndPoint(2), rewards.getEndPoint(2));

        LadderGameResult expected = new LadderGameResult(switchedMap);
        LadderGameResult actual = new LadderGameResult(participants, oneLadderLines, rewards);

        assertEquals(expected.getRewardResultStrings(ALL), actual.getRewardResultStrings(ALL));
    }

    private LadderLines getOneLadderLines(Boolean isLinked) {
        return new LadderLines(
            Arrays.asList(
                getLadderLineWithTwoPoints(isLinked)
            )
        );
    }

    private LadderLines getOneLadderLines(Boolean isLinked1, Boolean isLinked2) {
        return new LadderLines(
            Arrays.asList(
                getLadderLineWithThreePoints(isLinked1, isLinked2)
            )
        );
    }

    private LadderLines getTwoLadderLines(Boolean isLinked1, Boolean isLinked2) {
        return new LadderLines(
                Arrays.asList(
                        getLadderLineWithTwoPoints(isLinked1),
                        getLadderLineWithTwoPoints(isLinked2)
                )
        );
    }

    private LadderLines getTwoLadderLines(Boolean isLinked1, Boolean isLinked2, Boolean isLinked3, Boolean isLinked4) {
        return new LadderLines(
                Arrays.asList(
                        getLadderLineWithThreePoints(isLinked1, isLinked2),
                        getLadderLineWithThreePoints(isLinked3, isLinked4)
                )
        );
    }

    private LadderLine getLadderLineWithTwoPoints(Boolean isLinked) {
        return new LadderLine(
            Arrays.asList(
                new Point(0, Direction.of(FALSE, isLinked)),
                new Point(1, Direction.of(isLinked, FALSE))
            )
        );
    }

    private LadderLine getLadderLineWithThreePoints(Boolean isLinked1, Boolean isLinked2) {
        return new LadderLine(
            Arrays.asList(
                new Point(0, Direction.of(FALSE, isLinked1)),
                new Point(1, Direction.of(isLinked1, isLinked2)),
                new Point(2, Direction.of(isLinked2, FALSE))
            )
        );
    }

    private EndPoints getEndPoints(List<EndPoint> participants) {
        return new EndPoints(participants);
    }
}