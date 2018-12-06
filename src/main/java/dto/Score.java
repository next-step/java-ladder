package dto;

import java.util.Arrays;
import java.util.List;

public class Score {

    private List<String> scores;

    public Score(String scores) {
        this.scores = ofListString(scores);
    }

    private List<String> ofListString(String input){
       return Arrays.asList(input.split(","));
    }

    public int size() {
        return this.scores.size();
    }

    public String nthScore(int nth) {
        return this.scores.get(nth);
    }

    public List<String> getScores() {
        return scores;
    }
}
