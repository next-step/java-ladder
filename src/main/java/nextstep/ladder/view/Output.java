package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String BAR_POINT = "-----";
    private static final int LINE_POINT_CNT = 5;
    private static final String EMPTY_POINT = "     ";

    public static void printNameList(List<Name> nameList){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<nameList.size(); i++){
            Name name = nameList.get(i);
            sb.append(getBlank(LINE_POINT_CNT + 1  - name.getName().length()));
            sb.append(name.getName());
        }
        System.out.println(sb);
    }


    private static String getBlank(int cnt) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt; i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void printLadder(Ladder ladder){
        ladder.getLineList()
                .forEach(Output::printLine);
    }

    private static void printLine(Line line){
        StringBuilder sb = new StringBuilder();
        sb.append(EMPTY_POINT);
        sb.append("|");

        line.getPointList()
                .forEach(point->{
                    if(point){
                        sb.append(BAR_POINT);
                    }else{
                        sb.append(EMPTY_POINT);
                    }
                    sb.append("|");
                });

        System.out.println(sb);
    }
}
