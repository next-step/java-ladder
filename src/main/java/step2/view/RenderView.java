package step2.view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.User;
import step2.domain.UserList;

import java.util.stream.Collectors;

public class RenderView {
    private static final String EMPTY_LINE_TEMPLATE = "    ";
    private static final String LINE_TEMPLATE = "--------";

    public static void renderUserNameList(UserList userList) {
        String userNameList = userList.stream()
                .map(User::getName)
                .collect(Collectors.joining(EMPTY_LINE_TEMPLATE));

        System.out.println(userNameList);
    }

    public static void renderLadder(Ladder ladder) {
        for (Line line : ladder) {
            System.out.println(renderLine(line));
        }
    }

    private static String renderLine(Line line) {
        StringBuilder sb = new StringBuilder();

        boolean leftPoint = false;

        for (Boolean currentPoint : line) {
            sb.append("|");
            sb.append(leftPoint && currentPoint ? LINE_TEMPLATE : EMPTY_LINE_TEMPLATE + EMPTY_LINE_TEMPLATE);
            leftPoint = currentPoint;
        }

        return sb.toString();
    }
}
