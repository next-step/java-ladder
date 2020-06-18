package nextstep.step2;

import java.util.List;

public class ResultView {
    private List<String> names;
    private List<Line> ladders;

    public ResultView(List<String> names, List<Line> ladders) {
        this.names = names;
        this.ladders = ladders;
    }

    public void displayLadder() {
        names.forEach(name -> System.out.printf("%7s", name));
        System.out.println();
        ladders.stream().forEach(line -> {
            line.getOneLayerLadder().stream().forEach(aBoolean -> {
                System.out.print("|");
                if (aBoolean) {
                    System.out.printf("%5s", "-----");
                } else {
                    System.out.printf("%5s", "");
                }
            });
            System.out.println();
        });
    }
}
