package segelzwerg.sporttooolbox.web.speed;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.IUnits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.speed.Knot;
import segelzwerg.sporttooolbox.IUnits.speed.MilePerHour;
import segelzwerg.sporttooolbox.IUnits.speed.Speed;

/**
 * Represent speed in different units
 */
@Getter
@ToString
public class SpeedPresenter {
    private KilometerPerHour kilometerPerHour;
    private MilePerHour milesPerHour;
    private Knot knots;

    public SpeedPresenter(Speed speed) {
        kilometerPerHour = (KilometerPerHour) speed.toKilometerPerHour().format();
        milesPerHour = (MilePerHour) speed.toMilePerHour().format();
        knots = (Knot) speed.toKnot().format();
    }
}
