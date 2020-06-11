package TodoApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println(Arrays.toString(args));
        if (args.length == 0) {
            nothing();

        } else if (!(args[0].equals("-l") || args[0].equals("-a") || args[0].equals("-r") || args[0].equals("-c"))) {
            System.out.println("Unsupported argument");
            nothing();

        } else if (args[0].equals("-l")) {
            listing();

        } else if (args[0].equals("-a")) {
            if (args.length == 1) {
                System.out.println("Feed the monkey");
            } else
                addNewItem(args[1]);

        } else if (args[0].equals("-r")) {
            if (args.length == 1) {
                System.out.println("Unable to remove because the lack of an index");

            } else {
                removeItem(args[1]);
            }

        } else if (args[0].equals("-c")) {
            if (args.length == 1) {
                System.out.println("Unable to check because the lack of an index");
            } else {
                checkTask(args[1]);
            }
        }
    }


    public static void nothing() {
        System.out.println("Command Line Todo application \n" +
                "==================== \n" +
                "Command line arguments: \n" +
                "-l List all the tasks\n" +
                "-a Adds a new task \n" +
                "-r Removes a task \n" +
                "-c Completes a task");


    }

    public static void listing() throws IOException {
        Path filePath = Paths.get("TodoApp/Tasks.txt");
        List<String> lines = readAllLines(filePath);
        if (lines.size() > 0) {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(i + 1 + "- " + lines.get(i));
            }
        } else
            System.out.println("No todos for today! :)");
    }

    public static void addNewItem(String args) throws IOException {
        Path filePath = Paths.get("TodoApp/Tasks.txt");
        List<String> newItem = readAllLines(filePath);
        newItem.add("[ ]" + args);
        Files.write(filePath, newItem);
        System.out.println("Item added");
    }

    public static void removeItem(String args) throws IOException {
        Path filePath = Paths.get("TodoApp/Tasks.txt");
        List<String> items = readAllLines(filePath);
        int index = Integer.parseInt(args) - 1;
        if (items.size() >= 2) {
            items.remove(index);
            System.out.println("Item removed from " + (index + 1) + " . position");
            Files.write(filePath, items);
        }
    }

    public static void checkTask(String args) throws IOException {
        Path filePath = Paths.get("TodoApp/Tasks.txt");
        List<String> items = readAllLines(filePath);
        int index = Integer.parseInt(args) - 1;
        if (items.size() >= 2) {
            items.set(index, "[x" + items.get(index).substring(2));
            System.out.println("Task number " + (index + 1) + " is done.");
            Files.write(filePath, items);

        }
    }
}