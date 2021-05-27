package ca.bcit_research.ema.HardwareModeling;

import java.util.Scanner;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class OtherPropertyKeyValueProvider implements ValueProvider<KeyValue<String, String>> {
    @Override
    public KeyValue<String, String> get() {
        Scanner sc = new Scanner(System.in);
        String key = "";

        System.out.println("Creating a new property:");
        while (key.length() == 0) {
            System.out.println("Please enter a name at least 1 character long");
            key = sc.nextLine();
        }

        System.out.println("Please enter a value");
        String value = sc.nextLine();
        System.out.println();

        return new OtherProperty(key, value);
    }
}
