package domain;

import java.util.Arrays;

import static java.util.Optional.ofNullable;

public class Results {

    private final String[] results;

    public Results(final String[] results) {

        ofNullable(results).orElseThrow(IllegalArgumentException::new);

        if (results.length == 0) {
            throw new IllegalArgumentException();
        }

        for (final String result : results) {
            if (result == null) {
                throw new IllegalArgumentException();
            }
        }

        this.results = results;
    }

    public boolean eqRewards(final String[] values) {
        return this.results == values;
    }

    public int size() {
        return this.results.length;
    }

    public String findReward(final int playerNo) {
        return this.results[playerNo];
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Results results1 = (Results) o;
        return Arrays.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(results);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            final String result = results[i];
            if (i > 0) {
                sb.append("     ");
            }
            sb.append(result);
        }
        return sb.toString();
    }

}
