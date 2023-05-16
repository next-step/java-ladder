package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Participant;

import java.util.List;

public class OutputView {

    public static void showLadder(Ladder ladder) {
        System.out.println("실행결과");
        Participant participant = ladder.getParticipant();
        int height = ladder.getHeight();
        List<Line> lines = ladder.getLines();

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


    }
}
