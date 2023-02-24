import java.time.LocalDate;

public class WeeklyTask extends Task {
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDataTime().toLocalDate().getDayOfMonth();
    }
}
