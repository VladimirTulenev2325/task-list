import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private static List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        setUTF8Encoding();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Отметить задачу как выполненную");
            System.out.println("4. Вывести список задач");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Программа завершена.");
                    break;
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    printTaskList();
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }

    private static void setUTF8Encoding() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Ошибка при установке кодировки UTF-8: " + e.getMessage());
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Введите задачу: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Задача добавлена.");
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Введите номер задачи для удаления: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            String removedTask = tasks.remove(taskIndex - 1);
            System.out.println("Задача \"" + removedTask + "\" удалена.");
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Введите номер задачи для отметки как выполненной: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            String completedTask = tasks.get(taskIndex - 1);
            System.out.println("Задача \"" + completedTask + "\" отмечена как выполненная.");
            tasks.remove(taskIndex - 1);
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }

    private static void printTaskList() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}