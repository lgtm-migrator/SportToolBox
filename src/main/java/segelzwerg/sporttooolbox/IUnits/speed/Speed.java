package segelzwerg.sporttooolbox.IUnits.speed;

import segelzwerg.sporttooolbox.IUnits.Time;

/**
 * Speed interface
 */
public interface Speed {

    public static final float METER_PER_SECOND_TO_KILOMETER_PER_HOUR = 3.6f;
    public static final float MILE_PER_HOUR_TO_KILOMETER_PER_HOUR = 1.609344f;
    public static final float KNOT_TO_KILOMETER_PER_HOUR = 1.852f;

    /**
     * Convert to kilometer per hour
     *
     * @return speed in kilometer per hour
     */
    Speed toKilometerPerHour();

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    Speed toMeterPerSecond();

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    Speed toMilePerHour();

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    Speed toKnot();

    float getSpeed();

    public Speed format();

    /**
     * computes the time for a given kilometer and meter
     *
     * @param kilometer integer of the distance in kilometer
     * @param meter     decimal of distance as integer
     * @return time with hours, minutes and seconds
     */
    Time computeTime(float kilometer, float meter);
}
