import java.util.Scanner;

// import CourseWork2.TaskService.*;
public class Main {
    public static void main(String[] args) {
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
                    System.out.println("Выберете номер команды из меню: ");
                }
            }
            System.out.println("Чао!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getArgument());
        }
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n" +
                "4. Отредактировать заголовок задачи\n" + "0. Выход");
    }


}