import java.time.LocalDate;

public class YearlyTask extends Task {
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDataTime().toLocalDate().getDayOfMonth();
    }
}
