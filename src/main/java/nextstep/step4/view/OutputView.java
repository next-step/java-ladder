package nextstep.step4.view;

import nextstep.step4.api.Ladder;
import nextstep.step4.api.Line;
import nextstep.step4.dto.LadderResponse;
import nextstep.step4.model.Name;
import nextstep.step4.model.Point;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String PIPE_LINE = "|";
    private static final String FIVE_BLANK = "     ";
    private static final String FOUR_BLANK = "     ";
    private static final String FIVE_LINE = "-----";
    private static final Name ALL = new Name("all");
    private static final String NOT_FOUNT = "";

    public void printLadderStatus(List<Name> names, Ladder ladder, List<String> rewards) {
        StringBuilder sb = new StringBuilder();
        sb.append("사다리 결과").append(NEW_LINE);

        appendNames(sb, names);
        appendLadder(sb, ladder);
        appendRewards(sb, rewards);

        System.out.println(sb);
    }

    private void appendNames(StringBuilder sb, List<Name> names) {
        sb.append(FOUR_BLANK);

        names.stream()
                .map(Name::getName)
                .forEach(name -> sb.append(String.format("%-6s", name)));

        sb.append(NEW_LINE);
    }

    private void appendLadder(StringBuilder sb, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        lines.stream().map(Line::getPoints)
                .forEach(points -> appendLine(sb, points));
    }

    private void appendLine(StringBuilder sb, List<Point> points) {
        sb.append(FIVE_BLANK).append(PIPE_LINE);

        for (int i = 1; i < points.size(); i++) {
            sb.append(points.get(i).isConnected() ? FIVE_LINE : FIVE_BLANK).append(PIPE_LINE);
        }

        sb.append(NEW_LINE);
    }

    private void appendRewards(StringBuilder sb, List<String> rewards) {
        sb.append(FOUR_BLANK);
        rewards.forEach(reward -> sb.append(String.format("%-6s", reward)));
        sb.append(NEW_LINE);
    }

    public void printNameResult(LadderResponse response, Name name) {
        if (name.equals(ALL)) {
            printAll(response);
            return;
        }

        printOnlyOne(response, name);
    }

    private void printAll(LadderResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);

        Map<Name, String> nameAndRewardMap = response.getNameAndRewardMap();
        nameAndRewardMap.keySet()
                .forEach(name -> sb.append(String.format("%s : %s", name.getName(), nameAndRewardMap.get(name))).append(NEW_LINE));

        System.out.println(sb);
    }

    private void printOnlyOne(LadderResponse response, Name name) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);

        Map<Name, String> nameAndRewardMap = response.getNameAndRewardMap();
        sb.append(nameAndRewardMap.getOrDefault(name, NOT_FOUNT)).append(NEW_LINE);

        System.out.println(sb);
    }

}
