package ladder.domain.factory;

import ladder.domain.Destination;
import ladder.domain.Destinations;

import java.util.List;
import java.util.stream.Collectors;

public final class DestinationFactory {

    private DestinationFactory() {
    }

    public static Destinations create(List<String> destinationResults){
        return new Destinations(createDestination(destinationResults));
    }

    private static List<Destination> createDestination(List<String> destinationResults){
        validateDestinations(destinationResults);

        return destinationResults.stream()
                .map(Destination::new)
                .collect(Collectors.toList());
    }

    private static void validateDestinations(List<String> destinationResults){
        if (destinationResults.size() < 2){
            throw new IllegalArgumentException("결과는 최소 2개 이상이어야 합니다.");
        }
    }
}
