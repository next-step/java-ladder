package nextstep.view;

import java.util.List;

import nextstep.domain.Bonus;
import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;
import nextstep.domain.Line;
import nextstep.domain.Name;
import nextstep.domain.Names;

/**
 * 출력 클래스
 */
public class OutputView {
    private static final char V = '|';
    private static final char H = '-';
    private static final int WIDTH = 5;

    /** 결과 */
    public void printLadder(Names names, Ladder ladder, List<Bonus> bonusList) {
        System.out.println("사다리 결과");

        // 1) 이름 줄
        System.out.println(formatNameLine(names));

        // 2) 사다리 줄
        ladder.lines()
            .forEach(line -> System.out.println(formatLadderLine(line)));

        // 3) 보너스
        System.out.println(formatBonusLine(bonusList));
    }

    /**
     * 단일 결과
     */
    public void printPersonalResult(int index, LadderResult result, List<Bonus> bonusList) {
        System.out.println("실행 결과");
        if (index == -1) {
            System.out.println("게임에 참여하지 않은 사람입니다.");
            return;
        }
        System.out.println(bonusList.get(result.get(index)));
    }

    /**
     * all 조회 결과 출력
     */
    public void printAllResults(Names names, LadderResult result, List<Bonus> bonuses) {
        System.out.println("실행 결과");
        for (int i = 0; i < names.size(); i++) {
            Name name = names.unmodifiableNames().get(i);
            Bonus bonus = bonuses.get(result.get(i));
            System.out.printf("%s : %s%n", name, bonus);
        }
    }

    /** 이름 formatting */
    private static String formatNameLine(Names names) {
        StringBuilder sb = new StringBuilder();
        for (Name name : names.unmodifiableNames()) {
            sb.append(" ")
                .append(padLeft(name.toString()));
        }
        return sb.toString();
    }

    private static String formatBonusLine(List<Bonus> bonusList) {
        StringBuilder sb = new StringBuilder();
        for (Bonus bonus : bonusList) {
            sb.append(" ")
                .append(padLeft(bonus.toString()));
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
