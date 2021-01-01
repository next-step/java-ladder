package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {
    private String PRINT_PEOPLE_RESULTS = "all";

    public void printLadder(List<Person> people, List<Result> results, List<LadderLine> lines) {
        System.out.println("사다리 결과");
        System.out.println();

        for (Person person : people) {
            System.out.printf("%6s", person.getName());
        }
        System.out.println();

        for (int i = 0; i < lines.size(); i++) {
            printLine(lines.get(i), people.size());
            System.out.println();
        }

        for (Result result : results) {
            System.out.printf("%6s", result.getResultName());
        }
        System.out.println();

    }

    public void printLine(LadderLine line, int position) {
        List<String> strLines = new ArrayList<>();
        for (int i = 0; i < position; i++) {
            strLines.add(line.move(i) < i ? "-----|" : "     |");
        }
        for (String strLine : strLines) {
            System.out.printf(strLine);
        }
    }

    public void printResults(String name, People people, Map<Person, Result> matches){
        if("all".equals(name)){
            printPeopleResults(matches);
        }

        if(!"all".equals(name)){
            printPersonResults(name, people, matches);
        }

    }

    public void printPeopleResults(Map<Person, Result> matches) {
        for (Map.Entry<Person, Result> match : matches.entrySet()) {
            System.out.println(match.getKey().getName() + " : " + match.getValue().getResultName());
        }
    }

    public void printPersonResults(String name, People people, Map<Person, Result> matches) {
        System.out.println(matches.get(people.oneOfPerson(name)).getResultName());
    }

}
