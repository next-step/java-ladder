package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<User> users = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    private Ladder(int countOfUsers, int ladderHeight) {

        for(int i = 0; i < ladderHeight ; i ++){
            lines.add(Line.of(countOfUsers));
        }
    }

    public static Ladder of(int countOfUsers, int ladderHeight){
        return new Ladder(countOfUsers, ladderHeight);
    }

//    public String getLadderStr(){
//        StringBuilder str = new StringBuilder();
//
//        String userStr = users.stream()
//                                .map(User::toString)
//                                .collect(Collectors.joining(" "));
//
//        String ladderStr = lines.stream()
//                                    .map(Line::toString)
//                                    .collect(Collectors.joining("\n"));
//
//        str.append(userStr).append("\n").append(ladderStr);
//
//        return str.toString();
//    }

    public List<Line> getLines(){
        return new ArrayList<>(lines);
    }
}
