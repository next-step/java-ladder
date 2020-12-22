package nextstep.ladder.model;

import java.util.Arrays;

public class Results {
    private String[] results;

    public Results(String results){

        this.results = Arrays.stream(results.split(","))
                            .map(String::trim)
                            .toArray(String[]::new);
    }

    public String[] getResults(){
        return results;
    }
}
