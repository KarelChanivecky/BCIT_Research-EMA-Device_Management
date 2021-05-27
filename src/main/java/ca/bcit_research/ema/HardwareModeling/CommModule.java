package ca.bcit_research.ema.HardwareModeling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class CommModule implements WithOtherProperties {
    CommMethod commMethod;
    ArrayList<OtherProperty> properties = new ArrayList<>();

    public CommModule(CommMethod commMethod) {
        this.commMethod = commMethod;
    }

    @Override
    public boolean addOtherProperty(OtherProperty otherProperty) {
        return properties.add(otherProperty);
    }

    @Override
    public List<OtherProperty> getProperties() {
        return properties;
    }

    @Override
    public boolean removeProperty(OtherProperty otherProperty) {
        return properties.remove(otherProperty);
    }

    @Override
    public boolean swapProperties(OtherProperty newProperty, OtherProperty oldProperty) {
        if (!properties.remove(oldProperty)){
            return false;
        }

        if (!properties.add(newProperty)) {
            properties.add(oldProperty);
            return false;
        }

        return true;
    }
}
