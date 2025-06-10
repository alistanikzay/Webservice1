package se.iths.app;

import se.iths.spi.Converter;
import se.iths.spi.ConverterName;

import java.util.*;

public class ConverterApplication {

    public static void main(String[] args) {
        // Laddar alla implementationer av Converter via ServiceLoader
        ServiceLoader<Converter> loader = ServiceLoader.load(Converter.class);

        List<Converter> converters = new ArrayList<>();
        Map<Integer, Converter> menuMap = new HashMap<>();

        int index = 1;

        System.out.println("Select converter:\n");
        // Skapar meny med alla converters

        for (Converter converter : loader) {
            // Hämtar namnet från @ConverterName-annoteringen
            ConverterName annotation = converter.getClass().getAnnotation(ConverterName.class);
            String name = annotation != null ? annotation.value() : converter.getClass().getSimpleName();

            System.out.println(index + ". " + name);
            menuMap.put(index, converter);
            converters.add(converter);
            index++;
        }

        if (menuMap.isEmpty()) {
            System.out.println("No converters found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // Användaren väljer converter
        System.out.print("\nYour choice: ");
        int choice = scanner.nextInt();

        Converter selectedConverter = menuMap.get(choice);
        if (selectedConverter == null) {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("Enter value to convert: ");
        double value = scanner.nextDouble();

        String converterName = "";
        ConverterName annotation = selectedConverter.getClass().getAnnotation(ConverterName.class);
        if (annotation != null) {
            converterName = annotation.value();
        }

        double result;
        String formattedResult;

        if (converterName.toUpperCase().contains("KILOMETERS")) {
            result = selectedConverter.KilometersToMeters(value);
            formattedResult = (int)result + " m";
            System.out.println("Converted value: " + formattedResult);
        } else if (converterName.toUpperCase().contains("FAHRENHEIT")) {
            result = selectedConverter.DegreesToFahrenheit(value);
            formattedResult = (int)result + " °F";
            System.out.println("Converted value: " + formattedResult);
        } else {
            System.out.println("Unknown converter type.");
        }
    }
}