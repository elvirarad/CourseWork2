import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String title, Type type, String description, LocalDateTime dataTime, RepeatabilityTask repeatabilityTask) {
        super(title, type, description, dataTime, repeatabilityTask);
    }

//    public MonthlyTask(String title, Type type, String description, LocalDateTime dataTime) {
//        super(title, type, description, dataTime);
//    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDataTime().toLocalDate().getDayOfMonth();
    }
}
