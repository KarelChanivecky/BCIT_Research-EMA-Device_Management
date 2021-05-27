package ca.bcit_research.ema.HardwareModeling;

/**
 * This enum models the possible comm methods used.
 *
 * The string values here MUST align with the specification protocols.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public enum CommMethods {
    WIFI {
        public String toString() {
            return "wifi"; // TODO check for correctness
        }
    },
    BLUETOOTH {
        public String toString() {
            return "bluetooth"; // TODO check for correctness
        }
    }
}
