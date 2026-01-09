package nextstep.laddergame.view;

import java.util.List;
import nextstep.laddergame.domain.Goal;
import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.domain.LadderResult;
import nextstep.laddergame.domain.Line;
import nextstep.laddergame.domain.Participant;

public class OutputView {

    private static final int NAME_WIDTH = 5;
    private static final String ALL_TARGET = "all";

    public static void printLadderResult(LadderGame ladderGame) {
        List<Participant> participants = ladderGame.participants().participantList();
        List<Line> lines = ladderGame.ladder().lines();
        List<Goal> goals = ladderGame.ladder().goals();

        System.out.println("사다리 결과");

        if (lines.isEmpty()) {
            System.out.println(renderNames(participants, NAME_WIDTH));
            System.out.println(renderGoals(goals, NAME_WIDTH));
            return;
        }

        int verticalCount = participants.size();

        int nameWidth = NAME_WIDTH;

        // 1) 이름 라인
        System.out.println(renderNamesByVerticalCount(participants, verticalCount, nameWidth));

        // 2) 사다리 본문
        String ladderMargin = margin(nameWidth - 1);
        for (Line line : lines) {
            System.out.println(ladderMargin + renderLine(line, verticalCount, nameWidth));
        }

        // 3) 결과 라인
        System.out.println(renderGoals(goals, nameWidth));
    }

    public static void printResult(List<LadderResult> ladderResults, String target) {
        System.out.println("실행 결과");
        if (ALL_TARGET.equals(target)) {
            printAllResults(ladderResults);
            return;
        }

        ladderResults.stream()
            .filter(result -> result.name().equals(target))
            .findFirst()
            .ifPresent(result -> System.out.println(result.goal()));
    }

    // ----- render helpers -----

    // 참가자 이름을 "세로줄 개수" 기준으로 맞춰 출력 (participants 수가 모자라면 번호로 채움)
    private static String renderNamesByVerticalCount(List<Participant> participants, int verticalCount, int w) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < verticalCount; i++) {
            String label;
            if (i < participants.size()) {
                label = participants.get(i).name();
            } else {
                label = String.valueOf(i + 1); // participants가 부족할 때 임시 라벨
            }
            sb.append(padRight(label, w));
            if (i < verticalCount - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String renderNames(List<Participant> participants, int w) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < participants.size(); i++) {
            sb.append(padRight(participants.get(i).name(), w));
            if (i < participants.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String renderLine(Line line, int verticalCount, int w) {
        List<Boolean> points = line.points();

        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < verticalCount - 1; i++) {
            boolean connected = (i < points.size()) && points.get(i);
            sb.append(connected ? "-".repeat(w) : " ".repeat(w));
            sb.append("|");
        }
        return sb.toString();
    }

    private static String renderGoals(List<Goal> goals, int w) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < goals.size(); i++) {
            sb.append(padRight(goals.get(i).goal(), w));
            if (i < goals.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static void printAllResults(List<LadderResult> ladderResults) {
        for (LadderResult result : ladderResults) {
            System.out.println(result.name() + " : " + result.goal());
        }
    }

    private static String padRight(String s, int w) {
        if (s.length() >= w) {
            return s;
        }
        return s + " ".repeat(w - s.length());
    }

    private static String margin(int spaces) {
        return " ".repeat(Math.max(0, spaces));
    }
}