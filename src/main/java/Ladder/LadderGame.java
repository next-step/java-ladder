package Ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Map<Person, Result> oneGameResult = new HashMap<>();
    private Lines lines;


    public LadderGame(Lines lines) {
        this.lines = lines;
    }


    public LadderResult calculateResult(Persons persons, Results results) {
        for (int i = 0; i < persons.personCount(); i++) {

            int resultPosition = this.calculateLadder(i);
            oneGameResult.put(persons.getOnePerson(i), results.getOneResult(resultPosition));
        }
        return new LadderResult(oneGameResult);
    }
    //한사람 마다 결과값을 구하는거
    public int calculateLadder(int position) {
        int resultPosition = position;

        for(int i=0; i < lines.totalLineNum();i++){
            resultPosition = lines.getOneLine(i).decideDestination(resultPosition);
        }
        return resultPosition;
    }



}
