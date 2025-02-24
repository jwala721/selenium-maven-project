package genericutilities;

import java.util.List;
import java.util.stream.Collectors;

public class StationUtils {
    // Utility method to normalize station names
    public static List<String> normalizeStationNames(List<String> stationList) {
        return stationList.stream()
                .map(station -> station.contains(",") ? station.split(",")[1].trim() : station.trim())
                .distinct() // Remove duplicates
                .collect(Collectors.toList());
    }
}
