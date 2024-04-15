package view;

import domain.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView implements LadderVisitor {

    private static void printBridges(List<Boolean> bridges) {
        boolean prev = false;
        for (Boolean bridge : bridges) {
            System.out.printf("%s|", prev ? "-".repeat(5) : " ".repeat(5));
            prev = bridge;
        }
    }

    @Override
    public void visitBridges(List<Bridges> bridges) {
        for (int i = 0; i < bridges.size(); i++) {
            Bridges bridges1 = bridges.get(i);

        }
    }

    @Override
    public void visit(List<Player> players) {
        String result = players.stream()
                .map(player -> String.format("%5s", player))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    @Override
    public void visit(Collection<Reward> rewards) {
        String result = rewards.stream()
                .map(reward -> String.format("%5s", reward))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public void print(GameResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getPlayer() + " : " + result.getReward());
    }

    public void print(GameResults results) {
        System.out.println("실행 결과");
        for (GameResult result : results) {
            System.out.println(result.getPlayer() + " : " + result.getReward());
        }
    }
}
