package serialChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeviceListReader {

    public static List<String> readDevices(String fileName) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(DeviceListReader.class.getResourceAsStream("/" + fileName))))) {
            return reader.lines()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        }
    }
}
