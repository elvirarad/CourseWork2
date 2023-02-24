import java.util.*;

public class TaskService{

    static Set<Task> archiveRemovedTaskSet = new HashSet<>();
    public static Map<Integer, Task> tasks = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addTask() {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();
        try {
            Task.checkTitle(taskName);
        } catch (IncorrectArgumentException e) {
            System.err.println("title = \"" + taskName + "\" недопустимо - " + e.getMessage());
            throw new IllegalArgumentException();
        }
        System.out.print("Введите краткое описание задачи: ");
        String taskDescription = scanner.nextLine();
        System.out.print("\n *** Выберите тип задачи:\n 1 - рабочая (Work)\n 2 - личная (Personal)\n ваш выбор? :");
        Type taskTyp;

        int menu2 = scanner.nextInt();
        scanner.nextLine();

        switch (menu2) {
            case 1:
                taskTyp = Type.WORK;
                break;
            case 2:
                taskTyp = Type.PERSONAL;
                break;
            default: {
                System.out.println("ТИП задачи указан неверно!");
                taskTyp = Type.PERSONAL;
            }
        }

        System.out.print("\n *** Выберите повторяемость задачи:\n 1 - однократная\n" +
                " 2 - ежедневная\n 3 - еженедельная\n" +
                " 4 - ежемесячная\n 5 - ежегодная\n" +
                "ваш выбор? :");
        Task task9;
        int menu = scanner.nextInt();
        scanner.nextLine();

        switch (menu) {
            case 1:
                task9 = new OneTimeTask(taskName, taskTyp, taskDescription);
                break;
            case 2:
                task9 = new DailyTask(taskName, taskTyp, taskDescription);
                break;
            case 3:
                task9 = new WeeklyTask(taskName, taskTyp, taskDescription);
                break;
            case 4:
                task9 = new MonthlyTask(taskName, taskTyp, taskDescription);
                break;
            case 5:
                task9 = new YearlyTask(taskName, taskTyp, taskDescription);
                break;
            default: {
                System.out.println("ПОВТОРЯЕМОСТЬ задачи указана невнрно, ты всё сломал !");
                task9 = new OneTimeTask(taskName, taskTyp, taskDescription);
            }
        }
//        if (!tasks.contains(task9)) tasks.add(task9);
        tasks.put(task9.getId(), task9);
        System.out.println("Вот что вы навводили:\n" + task9);

    };

    public static void removeTask(){

    };

    public static void getAllByDate(){

    };
    public static void updateTitle(){

    };

}
