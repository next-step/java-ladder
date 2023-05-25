package nextstep.ladder.view;

import nextstep.ladder.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OutputView {

    public static void showLadder(LadderGame ladderGame) {
        System.out.println("실행결과");
        Ladder ladder = ladderGame.getLadder();
        int height = ladder.getHeight();
        List<Line> lines = ladder.getLines();
        Participant participant = ladderGame.getParticipant();
        LadderResult ladderResult = ladderGame.getResult();

        participant.getParticipants().stream()
                .forEach(name -> {
                    System.out.printf("%5s ", name);
                });
        System.out.println("");

        for (int i = 0; i < height; i++) {
            System.out.print("     |");
            Line line = lines.get(i);
            List<Boolean> point = line.getPoints();

            point.stream()
                    .forEach(p -> {
                                if (p) {
                                    System.out.print("-----|");
                                } else {
                                    System.out.print("     |");
                                }
                            }
                    );
            System.out.println("");
        }

        ladderResult.getResult().stream()
                .forEach(
                        result -> {
                            System.out.printf("%5s ", result);
                        }
                );
        System.out.println("");
    }

    public static void showResult(LadderGame ladderGame) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> gameResult = ladderGame.play();

        System.out.println("결과를 보고 싶은 사람은");
        String who = scanner.nextLine();

        while(!who.equals("all")){

            System.out.println("실행 결과");
            System.out.println(gameResult.get(who));

            System.out.println("결과를 보고 싶은 사람은");
            who = scanner.nextLine();
        }

        System.out.println("실행 결과");
        for (Name participant : ladderGame.getParticipants()) {
            System.out.println(participant.name() + " : " + gameResult.get(participant.name()));
        }
    }
}
