import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask (String title, Type type, String description, LocalDateTime dataTime, RepeatabilityTask repeatabilityTask) {
        super(title, type, description, dataTime, repeatabilityTask);
    }

//    public OneTimeTask (String title, Type type, String description, LocalDateTime dataTime) {
//        super(title, type, description, dataTime);
//    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDataTime().toLocalDate());
    }

}
