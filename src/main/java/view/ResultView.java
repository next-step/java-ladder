package view;

import model.*;

import java.util.List;

public class ResultView {
    /**
     * 실행 결과 출력
     *
     * @param participants
     * @param lines
     */
    public static void printResult(List<Participant> participants, List<Line> lines, List<Result> result) {
        System.out.println("실행결과");
        printParticipants(participants);
        System.out.println();
        printLadder(lines);
        System.out.println();
        printResults(result);
        System.out.println();
    }

    public static void printExecuteResult(String name, List<Participant> participants, List<Line> lines, List<Result> results) {
        System.out.println();
        System.out.println("실행결과");
        if (Participant.isAll(name)) {
            printExecuteResults(participants, lines, results);
        } else {
            printExecuteResultOne(name, participants, lines, results);
        }
        System.out.println();
    }

    public static void printExecuteResultOne(String name, List<Participant> participants, List<Line> lines, List<Result> results) {
        System.out.println(Result.getExecuteResult(name, participants, lines, results).getValue());
    }

    public static void printExecuteResults(List<Participant> participants, List<Line> lines, List<Result> results) {
        participants.stream()
                .forEach(p -> {
                    String name = p.getName();
                    System.out.println(name + " : " + Result.getExecuteResult(name, participants, lines, results).getValue());
                });
    }

    /**
     * 결과 목록 출력하기
     *
     * @param result
     */
    private static void printResults(List<Result> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%6s", result.get(i).getValue());
        }
    }

    /**
     * 사다리 출력
     *
     * @param lines
     */
    private static void printLadder(List<Line> lines) {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            List<Position> points = line.getPoints();
            printLines(points);
        }
    }

    /**
     * 참가자 출력
     *
     * @param participants
     */
    private static void printParticipants(List<Participant> participants) {
        for (Participant participant : participants) {
            System.out.printf("%6s", participant.getName());
        }
    }

    /**
     * 라인들 출력
     *
     * @param points
     */
    private static void printLines(List<Position> points) {
        System.out.print("   ");
        for (int j = 0; j < points.size(); j++) {
            printLine(points, j);
        }
        System.out.println();
    }

    /**
     * 라인 출력
     *
     * @param points
     * @param j
     */
    private static void printLine(List<Position> points, int j) {
        if (points.get(j).hasRight()) {
            System.out.print("|-----");
        } else {
            System.out.print("|     ");
        }
    }
}
