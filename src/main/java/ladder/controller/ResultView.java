package ladder.controller;

import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.Ladder;
import ladder.domain.Member;
import ladder.domain.Members;
import ladder.domain.Reword;
import ladder.domain.Rewords;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static final String HORIZONTAL_LINE = "-----";
    public static final String VERTICAL_LINE = "|";
    public static final String SPACES = "     ";
    public static final String ALL = "all";
    private static ResultView INSTANCE = null;

    private ResultView() {
    }

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void printLadders(Members members, Ladder ladder, Rewords rewords) {
        StringBuilder sb = new StringBuilder();
        sb.append("사다리 결과");
        sb.append(System.lineSeparator());
        sb.append(members.getMembers().stream()
                .map(member -> String.format("%5s ", member.getName()))
                .collect(Collectors.joining()));
        sb.append(System.lineSeparator());


        for (Line line : ladder.getLadders()) {
            printLines(line, sb);
        }

        sb.append(rewords.getRewords().stream()
                .map(reword -> String.format("%5s ", reword.getReword()))
                .collect(Collectors.joining()));
        System.out.println(sb);
    }

    public void printResult(LadderResult result, Member member) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과");
        sb.append(System.lineSeparator());
        if (ALL.equals(member.getName())) {
            printAllResult(result, sb);
            return;
        }
        sb.append(result.getReword(member).getReword());
        System.out.println(sb);
    }

    private static void printAllResult(LadderResult result, StringBuilder sb) {
        for (Map.Entry<Member, Reword> entry : result.getRewordMap().entrySet()) {
            sb.append(String.format("%s : %s", entry.getKey().getName(), entry.getValue().getReword()));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private void printLines(Line line, StringBuilder sb) {
        addHorizontal(false, sb);
        for (int i = 1; i < line.getSize(); i++) {
            addHorizontal(line.getPoint(i - 1), sb);
        }
        sb.append(System.lineSeparator());
    }

    private void addHorizontal(boolean isPoint, StringBuilder sb) {
        if (isPoint) {
            sb.append(HORIZONTAL_LINE);
            sb.append(VERTICAL_LINE);
            return;
        }
        sb.append(SPACES);
        sb.append(VERTICAL_LINE);
    }
}
