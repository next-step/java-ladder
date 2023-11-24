package nextstep.fp;

public class WordLengthComparator implements Comparable<String> {

    private final String target;

    public WordLengthComparator(String target) {
        this.target = target;
    }

    @Override
    public int compareTo(String o) {
        return this.target.length() - o.length();
    }
}
