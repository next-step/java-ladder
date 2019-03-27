package laddergame.validator;

import laddergame.domain.EndPoint;

import java.util.List;

public class EndPointsValidator implements Validatable<List<EndPoint>> {

    @Override
    public boolean isValid(List<EndPoint> target) {
        return target != null && target.size() >= 2;
    }

    @Override
    public String getInvalidMessage() {
        return "참가자는 2인 이상이어야 합니다.";
    }
}