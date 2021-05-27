package ca.bcit_research.ema.HardwareModeling;

import java.util.List;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface WithOtherProperties {

    /**
     * Add a new property.
     * @param otherProperty the new property to add
     * @return true if added
     */
    boolean addOtherProperty(OtherProperty otherProperty);

    /**
     * Get a list of properties
     * @return a list of properties
     */
    List<OtherProperty> getProperties();

    /**
     * Remove a certain property
     * @param otherProperty The property to remove.
     * @return true if removed
     */
    boolean removeProperty(OtherProperty otherProperty);

    /**
     * Swap a property for another one.
     *
     * @param newProperty The property to remain
     * @param oldProperty The property to remove
     * @return true if swapped
     */
    boolean swapProperties(OtherProperty newProperty, OtherProperty oldProperty);
}
