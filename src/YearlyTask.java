import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {

    public YearlyTask (String title, Type type, String description, LocalDateTime dataTime, RepeatabilityTask repeatabilityTask) {
        super(title, type, description, dataTime, repeatabilityTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfYear() == getDataTime().toLocalDate().getDayOfYear();
    }
}
