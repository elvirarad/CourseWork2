import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 0;
    private String title;
    private Type type;
    private final int id;
    private LocalDateTime dataTime;
    private String description;

    public Task() {
        idGenerator++;
        id = idGenerator;
    }

    public Task(int idGenerator,
                String title,
                Type type,
                int id,
                LocalDateTime dataTime,
                String description) {
        this.title = title;
        this.type = type;
        this.id = id;
        this.dataTime = dataTime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dataTime=" + dataTime +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && title.equals(task.title) && type.equals(task.type) && dataTime.equals(task.dataTime) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dataTime, description);
    }
}
