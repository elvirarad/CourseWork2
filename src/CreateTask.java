import java.time.LocalDateTime;
import java.util.Scanner;

public class CreateTask {
    private static Type inputTaskType (Scanner scanner) {

        System.out.println ( "Выберите тип задачи выбрав пункт меню под нужной цифрой: " +
                "\n 1 - Личная \n 2 - Рабочая" );
        Type type = null;
        int taskType = scanner.nextInt ();
        if (taskType == 1) {
            type = Type.PERSONAL;
        } else if (taskType == 2) {
            type = Type.WORK;
        }
        return type;
    }

    private static String inputTaskTitle() throws IncorrectArgumentException {
        System.out.print ( "Введите название задачи: " );
        String myInput;
        Scanner myScanner = new Scanner (System.in).useDelimiter ( "\\n" );
        myInput = myScanner.next ();
        if (myInput == null||myInput.isEmpty ())
            throw new IncorrectArgumentException ( "Некорректно введены данные задачи" );
        System.out.println (myInput);
        return myInput;
    }
    private static String inputTaskDescriptions() throws IncorrectArgumentException {
        System.out.print ( "Введите описание задачи: " );
        String myInputDescriptions;
        Scanner myScanner = new Scanner ( System.in ).useDelimiter ( "\\n" );
        myInputDescriptions = myScanner.next ();
        if (myInputDescriptions == null||myInputDescriptions.isEmpty ()) {
            throw new IncorrectArgumentException ( "Некорректно введены данные задачи" );
        }
        System.out.println ( myInputDescriptions );
        return myInputDescriptions;
    }

    public static LocalDateTime createLeadTime(Scanner scanner) {

        System.out.println("введите дату и время выполнения задачи в формате (" + Main.DATE_TIME_FORMAT + "): ");
        var strDateTime = scanner.next();
        LocalDateTime time = LocalDateTime.parse(strDateTime, Main.DATE_TIME_FORMATTER);

        System.out.println (time);
        return time;
    }


    public static Task createTask(Scanner scanner) throws IncorrectArgumentException {
        while (true) {
            System.out.println ( "Выберите периодичность повторения задачи указав нужный пункт меню : " +
                    "\n 1 - однократная " +
                    "\n 2 - ежедневная " +
                    "\n 3 - еженедельная " +
                    "\n 4 - ежемесячная " +
                    "\n 5 - ежегодная" );
            int taskRepeat = scanner.nextInt ();
            switch (taskRepeat) {
                case 1:
                    return new OneTimeTask(inputTaskTitle(), inputTaskType(scanner),  inputTaskDescriptions(), createLeadTime(scanner), RepeatabilityTask.TASK_ONE_TIME );
                case 2:
                    return new DailyTask( inputTaskTitle(),inputTaskType(scanner),  inputTaskDescriptions(), createLeadTime(scanner), RepeatabilityTask.TASK_DAILY );
                case 3:
                    return new WeeklyTask( inputTaskTitle(), inputTaskType(scanner),  inputTaskDescriptions(), createLeadTime(scanner), RepeatabilityTask.TASK_WEEKLY );
                case 4:
                    return new MonthlyTask( inputTaskTitle(), inputTaskType(scanner),  inputTaskDescriptions(), createLeadTime(scanner), RepeatabilityTask.TASK_MONTH );
                case 5:
                    return new YearlyTask( inputTaskTitle(), inputTaskType(scanner),  inputTaskDescriptions(), createLeadTime(scanner), RepeatabilityTask.TASK_YEARLY );
            }
            System.out.println ( "Ввведите правильный пункт меню " );
        }
    }


}
