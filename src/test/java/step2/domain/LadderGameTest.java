package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Names;
import step2.view.OutputView;

class LadderGameTest {
    @Test
    void printTest() {
        final Names names = new Names("a,b,c,d" .split(","));
        final LadderGame ladderGame = new LadderGame(names.names(), 5);
        System.out.println(ladderGame);


        for (Ladder ladder : ladderGame.ladders()) {
            System.out.printf("%6s", ladder.name());
        }

        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ladderGame.ladders().size(); i++) {
            for (Ladder ladder : ladderGame.ladders()) {
                final Boolean point = ladder.line().points().get(i);
                if (point) {
                    sb.append("-----|");
                }
                else {
                    sb.append("     |");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    @Test
    void printTest2() {
        final OutputView outputView = new OutputView();
        final Names names = new Names("a,b,c,d" .split(","));
        final LadderGame ladderGame = new LadderGame(names.names(), 5);
        outputView.printLadderGame(ladderGame);
    }
}