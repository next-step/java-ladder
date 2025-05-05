package nextstep.view;

import java.util.List;

import nextstep.domain.Bonus;
import nextstep.domain.Bonuses;
import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;
import nextstep.domain.Line;
import nextstep.domain.Participant;
import nextstep.domain.Participants;

/**
 * 출력 클래스
 */
public class OutputView {
    private static final char V = '|';
    private static final char H = '-';
    private static final int WIDTH = 5;

    /** 결과 */
    public void printLadder(Participants participants, Ladder ladder, Bonuses bonusList) {
        System.out.println("사다리 결과");

        // 1) 이름 줄
        System.out.println(formatNameLine(participants));

        // 2) 사다리 줄
        ladder.lines()
            .forEach(line -> System.out.println(formatLadderLine(line)));

        // 3) 보너스
        System.out.println(formatBonusLine(bonusList));
    }

    /**
     * 단일 결과
     */
    public void printPersonalResult(LadderResult result, String name) {
        System.out.println("실행 결과");
        System.out.println(result.findBonusByParticipantName(name));
    }

    /**
     * all 조회 결과 출력
     */
    public void printAllResults(LadderResult result) {
        System.out.println("실행 결과");
        result.getAllResult()
            .forEach((key, value) -> System.out.println(key + " : " + value));
    }

    /** 이름 formatting */
    private static String formatNameLine(Participants participants) {
        StringBuilder sb = new StringBuilder();
        for (Participant participant : participants.unmodifiableNames()) {
            sb.append(" ")
                .append(padLeft(participant.getName()));
        }
        return sb.toString();
    }

    private static String formatBonusLine(Bonuses bonusList) {
        StringBuilder sb = new StringBuilder();
        for (Bonus bonus : bonusList.unmodifiableNames()) {
            sb.append(" ")
                .append(padLeft(bonus.getName()));
        }
        return sb.toString();
    }

    /** 사다리 한 행을 formatting */
    private static String formatLadderLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(WIDTH)).append(V);
        for (boolean conn : line.statues()) {
            String fill = conn
                ? String.valueOf(H).repeat(WIDTH)
                : " ".repeat(WIDTH);
            sb.append(fill).append(V);
        }
        return sb.toString();
    }

    /** 좌측 공백 */
    private static String padLeft(String s) {
        if (s.length() >= WIDTH)
            return s;
        return " ".repeat(WIDTH - s.length()) + s;
    }
}
