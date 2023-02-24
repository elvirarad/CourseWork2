import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDataTime().toLocalDate());
    }
}
