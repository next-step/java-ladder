package game.domain;

import game.constant.Case;
import game.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GhostLegService {
    public List<Boolean> generateRandomLines(int listSize) {
        return Stream.generate(RandomNumberGenerator::randomBoolean)
                .limit(listSize - 1)
                .collect(Collectors.toList());
    }

    public List<Boolean> filterLines(List<Boolean> lines) {
        boolean prevStatus = lines.get(0);

        for (int index = 1; index < lines.size(); index++) {
            boolean currentStatus = lines.get(index);

            Case nextStep = checkStatus(prevStatus, currentStatus);
            changeStatus(nextStep, index, lines, RandomNumberGenerator.randomNumber(2));
            prevStatus = lines.get(index);
        }

        return lines;
    }

    private Case checkStatus(boolean previous, boolean current) {
        if (previous && current) return Case.TRUE;
        if (!previous && !current) return Case.FALSE;
        return Case.UNKNOWN;
    }

    private void changeStatus(Case nextStep, int index, List<Boolean> points, int generatedRandomNumber) {
        if (nextStep == Case.TRUE) resolveTrueCase(index, points, generatedRandomNumber);
        if (nextStep == Case.FALSE) resolveFalseCase(index, points, generatedRandomNumber);
    }

    private void resolveTrueCase(int index, List<Boolean> points, int generatedRandomNumber) {
        boolean validValue = validateTrueCase(index, points);
        switch (generatedRandomNumber) {
            case 0:
                points.set(index, false);
                break;
            case 1:
                points.set(index - 1, validValue);
                break;
        }
    }

    private void resolveFalseCase(int index, List<Boolean> points, int generatedRandomNumber) {
        boolean validValue = validateFalseCase(index, points);
        switch (generatedRandomNumber) {
            case 0:
                points.set(index, true);
                break;
            case 1:
                points.set(index - 1, validValue);
                break;
        }
    }

    private boolean validateFalseCase(int index, List<Boolean> points) {
        if (index >= 2) {
            return !points.get(index - 2);
        }
        return !points.get(index);
    }

    private boolean validateTrueCase(int index, List<Boolean> points) {
        if (index >= 2) {
            return points.get(index - 2);
        }
        return !points.get(index);
    }
}
