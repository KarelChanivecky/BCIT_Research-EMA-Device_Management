package ca.bcit_research.ema.HardwareModeling;

import java.util.List;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface WithMetrics {

    /**
     * Get a list of metrics.
     */
    List<Metric> getMetrics();

}
