package se.iths.temp;

import se.iths.spi.Converter;
import se.iths.spi.ConverterName;

@ConverterName("DEGREES TO FAHRENHEIT")
public class DegreesToFahrenheit implements Converter {

    @Override
    public double DegreesToFahrenheit(double degrees) {
        return degrees * 1.8 + 32;
    }

    @Override
    public double KilometersToMeters(double km) {
        return 0; // Not implemented
    }
}
