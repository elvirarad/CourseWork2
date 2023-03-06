import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, String description, LocalDateTime dataTime, RepeatabilityTask repeatabilityTask) {
        super(title, type, description, dataTime, repeatabilityTask);
    }

        @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(getDataTime().toLocalDate().getDayOfWeek());
    }
}
