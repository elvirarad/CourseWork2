import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// import CourseWork2.TaskService.*;
public class Main {
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy-HH:mm";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    public static void main(String[] args) throws  IncorrectArgumentException{
        TaskService service = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("---- Меню команд----");
                printMenu();
                System.out.print("Введите номер команды из меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            Task task;
                            task = CreateTask.createTask (scanner);
                            System.out.println(task);
                            try {
                                service.add(task);                                                                          // service.add(createTask)
                            }
                            catch (IncorrectArgumentException e)
                            {
                                e.printStackTrace();
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("Введите id задачи для удаления");
                            try {
                                service.removeTask(scanner.nextInt());
                            }
                            catch (TaskNotFoundException e){
                                e.printStackTrace();   // указывает в какой строке исключение
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            System.out.println("Введите дату чтобы посмотреть список задач, вводите дату в формате гггг - мм - дд: ");
                            System.out.println(service.getAllByDate(LocalDate.parse(scanner.next(), DateTimeFormatter.ISO_LOCAL_DATE)));
                            break;
                        case 4:
                            TaskService.updateTitle();
                            break;
                        case 0:
                            break label;
//                        default:
//                            System.out.println("Ошибка в выборе команды");
                    }
                } else {
                    scanner.next();
                    System.out.println ( "Выберите номер пункта из меню: " );
                }
            }
            System.out.println("Чао!");
            }
        }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n" +
                "4. Отредактировать описание задачи\n" + "0. Выход");
    }


}