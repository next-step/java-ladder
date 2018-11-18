package view;

import model.Line;
import model.Participant;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    /**
     * 실행 결과 출력
     *
     * @param participants
     * @param lines
     */
    public static void printResult(List<Participant> participants, List<Line> lines) {
        System.out.println("실행결과");
        printParticipants(participants);
        System.out.println();
        printLadder(lines);

    }

    /**
     * 사다리 출력
     *
     * @param lines
     */
    private static void printLadder(List<Line> lines) {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            ArrayList<Boolean> points = line.getPoints();
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
            System.out.printf("%s  ", participant.getName());
        }
    }

    /**
     * 라인들 출력
     *
     * @param points
     */
    private static void printLines(ArrayList<Boolean> points) {
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
    private static void printLine(ArrayList<Boolean> points, int j) {
        if (points.get(j).booleanValue()) {
            System.out.print("|-----");
        } else {
            System.out.print("|     ");
        }
    }
}
