package nextstep.ladder.view;

import java.io.PrintStream;
import java.util.function.Consumer;
import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Players;

public class ResultView {

    private final PrintStream sout;

    public ResultView(PrintStream out) {
        this.sout = out;
    }

    public static ResultView from(PrintStream out) {
        return new ResultView(out);
    }

    public void outputPlayers(Players players) {
        players.list().forEach(p -> System.out.print(p.name() + "  "));
        sout.println();
    }

    public void outputLadder(Ladder ladder) {
        ladder.lines().forEach(this::drawLadder);
    }

    private void drawLadder(Line line) {
        line.line().forEach(step -> {
            if (step.canMove()) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }
            System.out.print("|");
        });
        System.out.print("\n");
    }

    public void outputInitPlayers() {
        sout.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n");
    }

    public void outputInitLadderHeight(){
        sout.print("최대 사다리 높이는 몇 개인가요?\n");
    }

    public void outputInitGameResult() {
        sout.print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n");
    }

    public void outputGameResult(GameResult gameResult) {
        gameResult.list().forEach(s -> {
            if(tooSmallString(s.length())){
                System.out.print(s + "    ");
            }else{
                System.out.print(s + "  ");
            }
        });
        sout.println();
    }

    private boolean tooSmallString(int stringLength) {
        return stringLength <= 2;
    }
}
