import java.time.LocalDate;

public class DailyTask extends Task {
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDataTime().toLocalDate().getDayOfMonth();
    }
}
