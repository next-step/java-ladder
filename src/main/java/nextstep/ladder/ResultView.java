package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final List<User> users;
    private final Ladder ladder;

    public ResultView(String[] userStrArr, Ladder ladder) {
        this.users = Arrays.stream(userStrArr)
                .map(User::of)
                .collect(Collectors.toList());

        this.ladder = ladder;
    }

    public static ResultView of(String[] users, Ladder ladder){
        return new ResultView(users, ladder);
    }

    private String makeLadderUI(Line line){
        StringBuilder str = new StringBuilder();

        String lineStr = line.getLine().stream()
                            .map(this::getSignal)
                            .collect(Collectors.joining("|"));

        str.append("    ");
        str.append("|");
        str.append(lineStr);
        str.append("|");

        return str.toString();
    }

    private String getSignal(Point p){
        if(p.getDirection() == Direction.RIGHT){
            return "-----";
        }

        return "     ";
    }

    private String makeUserUI(String userName){
        return String.format("%5.5s", userName);
    }
    public void printResult(){
        StringBuilder str = new StringBuilder();

        String userStr = users.stream()
                .map(User::toString)
                .map(this::makeUserUI)
                .collect(Collectors.joining(" "));

        String ladderStr = ladder.getLines().stream()
                                    .map(this::makeLadderUI)
                                    .collect(Collectors.joining("\n"));

        str.append(userStr).append("\n").append(ladderStr);

        System.out.println(str.toString());
    }

}
