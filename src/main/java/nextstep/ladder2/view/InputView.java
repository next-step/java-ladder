package nextstep.ladder2.view;

import nextstep.ladder2.domain.player.Player;
import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.reward.Reward;
import nextstep.ladder2.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIM = ",";

    public static Players getPlayers() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for(String name: names.split(DELIM)) {
            players.add(new Player(name));
        }

        if (players.size() == 0) {
            throw new IllegalArgumentException("플레이어는 최소 1개 이상이어야 합니다.");
        }

        return new Players(players);
    }

    public static int getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();

        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }

        return height;
    }


    public static Rewards getRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();

        List<Reward> rewards = new ArrayList<>();
        for(String name: names.split(DELIM)) {
            rewards.add(new Reward(name));
        }

        if (rewards.size() == 0) {
            throw new IllegalArgumentException("보상은 최소 1개 이상이어야 합니다.");
        }

        return new Rewards(rewards);
    }

    public static Player getPlayerName() {
        System.out.println("\n결과를 보고 싶은 사람은?(종료=quit)");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Player player = new Player(name);

        return player;
    }
}
