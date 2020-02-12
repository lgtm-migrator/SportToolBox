package segelzwerg.sporttooolbox.web.pace;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.IUnits.pace.Pace;
import segelzwerg.sporttooolbox.calculators.SpeedCalculator;
import segelzwerg.sporttooolbox.calculators.SpeedCalculatorFactory;
import segelzwerg.sporttooolbox.calculators.TimeCalculator;
import segelzwerg.sporttooolbox.calculators.TimeCalculatorFactory;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Pace calculating service
 */
@Component
public class PaceService {

    List<String> validPaceUnits = new ArrayList<>(Arrays.asList("minutesPerKilometer", "minutesPerHundredMeters"));

    /**
     * calulates pace
     *
     * @param form
     * @return calculated pace
     */
    public Pace calculatePace(SpeedForm form) {
        String majorUnit = ((majorUnit = form.getDistanceMajorUnit()) != null) ? majorUnit : "kilometer";
        String minorUnit = ((minorUnit = form.getDistanceMinorUnit()) != null) ? minorUnit : "meter";
        String paceUnit = ((paceUnit = form.getPaceUnit()) != null) ? paceUnit : "minutesPerKilometer";

        checkValidUnit(validPaceUnits, paceUnit);

        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(form, majorUnit, minorUnit);

        return speedCalculator.computePace();
    }

    /**
     * calculates the time given a distance and speed
     *
     * @param paceForm contains distance and speed and their units
     * @return a Time object containing hours, minutes and seconds
     */
    public Time calculateTime(SpeedForm paceForm) {
        String majorUnit = ((majorUnit = paceForm.getDistanceMajorUnit()) != null) ? majorUnit : "kilometer";
        String minorUnit = ((minorUnit = paceForm.getDistanceMinorUnit()) != null) ? minorUnit : "meter";
        String paceUnit = ((paceUnit = paceForm.getPaceUnit()) != null) ? paceUnit : "minutesPerKilometer";

        checkValidUnit(validPaceUnits, paceUnit);

        TimeCalculator timeCalculator = TimeCalculatorFactory.buildFromPace(paceForm, majorUnit, minorUnit);
        return timeCalculator.computeTime();
    }

    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }
}
