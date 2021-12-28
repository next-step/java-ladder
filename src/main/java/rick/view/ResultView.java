package rick.view;

import java.util.List;
import java.util.Objects;
import rick.domain.Ladder;
import rick.domain.Line;
import rick.domain.Player;
import rick.domain.Players;
import rick.domain.Point;
import rick.domain.Reward;
import rick.domain.Rewards;

public class ResultView {

    private static final String NAME_FORMAT = "%6s";
    private static final String MESSAGE_LADDER_RESULT = "사다리 결과";
    private static final String MESSAGE_EXECUTION_RESULT = "실행 결과";
    private static final String MESSAGE_NO_PLAYER_MATCHED = "일치하는 플레이어 이름을 가지는 사람이 없습니다";

    private ResultView() {
    }

    public static void drawLadder(Players players, Rewards rewards, Ladder ladder) {
        System.out.println(MESSAGE_LADDER_RESULT);
        System.out.println();

        players.getPlayers()
            .stream()
            .map(Player::getName)
            .forEach(name -> System.out.printf(NAME_FORMAT, name));

        System.out.println();

        for (Line line : ladder.getLines()) {
            drawLine(line);
        }

        rewards.getRewards()
            .stream()
            .map(Reward::getName)
            .forEach(name -> System.out.printf("%6s", name));

        System.out.println();
    }

    private static void drawLine(Line line) {
        System.out.print("     |");
        List<Point> points = line.getPoints()
            .getPoints();

        for (int i = 0; i < points.size() - 1; i++) {
            drawPoint(points.get(i));
        }
        System.out.println();
    }

    private static void drawPoint(Point point) {
        if (point.movableToRight()) {
            System.out.print("-----|");
            return;
        }

        System.out.print("     |");
    }

    public static void drawPlayerResult(Players players, Rewards rewards, Ladder ladder, String playerName) {
        Player player = players.player(playerName);

        if (Objects.isNull(player)) {
            System.out.println(MESSAGE_NO_PLAYER_MATCHED);
        }

        Reward reward = players.reward(ladder, rewards, player);

        drawExcutionResult();
        System.out.println(reward.getName());
        System.out.println();
    }

    public static void drawAllRewards(Players players, Rewards rewards, Ladder ladder) {
        drawExcutionResult();
        players.getPlayers()
            .forEach(player -> {
                Reward reward = players.reward(ladder, rewards, player);
                System.out.printf("%s : %s%s", player.getName(), reward.getName(), System.lineSeparator());
            });
        System.out.println();
    }

    public static void drawExcutionResult() {
        System.out.println();
        System.out.println(MESSAGE_EXECUTION_RESULT);
    }
}
