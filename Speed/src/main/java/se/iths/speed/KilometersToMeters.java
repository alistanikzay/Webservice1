package se.iths.speed;

import se.iths.spi.Converter;
import se.iths.spi.ConverterName;

@ConverterName("KILOMETERS TO METERS")
public class KilometersToMeters implements Converter {
    @Override
    public double KilometersToMeters(double km) {
        return km * 1000;
    }

    @Override
    public double DegreesToFahrenheit(double degrees) {
        return 0; // Not implemented
    }
}
