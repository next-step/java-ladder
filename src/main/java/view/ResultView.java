package view;

import domain.LadderVisitor;
import domain.Line;
import domain.Player;
import domain.Reward;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView implements LadderVisitor {

    @Override
    public void visit(List<Line> lines, int height) {
        IntStream.rangeClosed(1, height)
                .forEach(i -> {
                    List<Boolean> bridges = lines.stream()
                            .map(line -> line.hasBridge(i))
                            .collect(Collectors.toList());

                    printBridges(bridges);
                    System.out.println();
                });
    }

    private static void printBridges(List<Boolean> bridges) {
        boolean prev = false;
        for (Boolean bridge : bridges) {
            System.out.printf("%s|", prev ? "-".repeat(5) : " ".repeat(5));
            prev = bridge;
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
}
