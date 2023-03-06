import java.time.LocalDate;
import java.util.*;

public class TaskService{

    private final Map<Integer, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<>();
    }

    public static Scanner scanner = new Scanner(System.in);

    public void add(Task task) throws IncorrectArgumentException {
        if (task.getTitle() == null || task.getDescription() == null) {
            throw new IncorrectArgumentException("Некорректно введены данные задачи");
        }
        taskMap.put(task.getId(), task);
    }
//
//        String taskName = scanner.nextLine();
//        checkTitle(taskName);
//        System.out.print("Введите краткое описание задачи: ");
//        String taskDescription = scanner.nextLine();
//        System.out.print("\n *** Выберите тип задачи:\n 1 - рабочая (Work)\n 2 - личная (Personal)\n ваш выбор? :");
//        Type taskTyp;
//
//        int menu2 = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (menu2) {
//            case 1:
//                taskTyp = Type.WORK;
//                break;
//            case 2:
//                taskTyp = Type.PERSONAL;
//                break;
//            default: {
//                System.out.println("ТИП задачи указан неверно!");
//                taskTyp = Type.PERSONAL;
//            }
//        }
//
//        System.out.print("\n *** Выберите повторяемость задачи:\n 1 - однократная\n" +
//                " 2 - ежедневная\n 3 - еженедельная\n" +
//                " 4 - ежемесячная\n 5 - ежегодная\n" +
//                "введите цифру из меню :");
//
//        Task task9;
//        int menu = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (menu) {
//            case 1:
//                task9 = new OneTimeTask(taskName, taskTyp, taskDescription, taskDataTime);
//                break;
//            case 2:
//                task9 = new DailyTask(taskName, taskTyp, taskDescription);
//                break;
//            case 3:
//                task9 = new WeeklyTask(taskName, taskTyp, taskDescription, );
//                break;
//            case 4:
//                task9 = new MonthlyTask(taskName, taskTyp, taskDescription);
//                break;
//            case 5:
//                task9 = new YearlyTask(taskName, taskTyp, taskDescription);
//                break;
//            default: {
//                System.out.println("Ошибка: ПОВТОРЯЕМОСТЬ задачи указана неверно !");
//                task9 = new OneTimeTask(taskName, taskTyp, taskDescription, );
//            }
//        }
//        if (!tasks.contains(task9)) tasks.add(task9);
//        put(task9.getId(), task9);
//        System.out.println("Вот что вы навводили:\n" + task9);

  //////  };

    public Task removeTask(int id) throws TaskNotFoundException{
        Task task = taskMap.remove ( id );
        if (task == null) {
            throw new TaskNotFoundException ( "В списке нет задачи с id " + id);
        }
        return task;
    };

    public Collection<Task> getAllByDate(LocalDate date) {
        // получение задач по дате
        ArrayList<Task> list = new ArrayList<>();
        for (int i = 1; i < taskMap.size () + 1; i++) {
            if (taskMap.get (i).appearsIn ( date )) {
                list.add ( taskMap.get ( i ) );
            }
        }
        if (list.isEmpty ()){
            System.out.println ("На сегодня задачи не созданы");
        }
        return list;
    }

    public static void updateTitle(){

    };

//    public static boolean checkTitle(String title){
//        if (title.equals("")) {
//            if (title.isBlank()) {
//                return true;
//            }
//        }
//        return false;
//
//    };
}
