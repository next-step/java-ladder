package ladder.domain;

import java.util.List;

public class Paths {

    private List<Path> paths;

    public Paths(List<Path> paths){
        this.paths = paths;
    }

    public List<Path> getPaths() {
        return paths;
    }
}
