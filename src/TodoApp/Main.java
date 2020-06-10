package TodoApp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {


        public static void main(String[] args) {
            List<String> toDo = new ArrayList<>();

            Path filePath = Paths.get("ToDos.txt");

            if (args[0].equals("-l")) {

            }


            if (args.length == 0) {
                System.out.println("Command Line ToDo application\n" +
                        "====================\n" +
                        "-l List all the tasks\n" +
                        "-a Adds a new task\n" +
                        "-r Removes a task\n" +
                        "-c Completes a task");
            }
        }
    }