import java.util.Scanner;
//import CourseWork2.TaskNotFoundException;
// import CourseWork2.TaskService.*;
public class Main {
    public static void main(String[] args) {

            Task 1 = new OneTimeTask("Переговоры" );
                    //"Task #1 oneTime", Type.WORK, null);
//            OneTimeTask  2 = new OneTimeTask("Task #2 oneTime", Type.PERSONAL, "Barbershop");
//            OneTimeTask  3 = new OneTimeTask("Task #3 oneTime", Type.WORK, " ");
//            DailyTask  = new DailyTask("Task #4 daily", Type.WORK, "Проверить почту");
//            DailyTask task5 = new DailyTask("Task #5 daily", Type.PERSONAL, "почистить зубы");
//            WeeklyTask task6 = new WeeklyTask("Task #6 weekly", Type.PERSONAL, "cleaning");
//            MonthlyTask task7 = new MonthlyTask("Task #7 monthly", Type.WORK, "monthly report");
//            YearlyTask task8 = new YearlyTask("Task #8 yearly", Type.WORK, "чей-то день рождения");

// вместо списка используем мапу
//            tasks.put(task1.getId(), task1);
//            tasks.put(task2.getId(), task2);
//            tasks.put(task3.getId(), task3);
//            tasks.put(task4.getId(), task4);
//            tasks.put(task5.getId(), task5);
//            tasks.put(task6.getId(), task6);
//            tasks.put(task7.getId(), task7);
//            tasks.put(task8.getId(), task8);

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("---- Меню команд----");
                printMenu();
                System.out.println("Введите номер команды из меню: ");

                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            TaskService.addTask();
                            break;
                        case 2:
                            TaskService.removeTask();
                            break;
                        case 3:
                            TaskService.getAllByDate();
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
                }
            }
            System.out.println("Чао!");
//        } catch (TaskNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IncorrectArgumentException e) {
//            System.out.println(e.getArgument());
            }
        }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n" +
                "4. Отредактировать описание задачи\n" + "0. Выход");
    }


}