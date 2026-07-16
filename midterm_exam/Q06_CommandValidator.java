package midterm_exam;

public class Q06_CommandValidator {
    public static void main(String[] args) {
        String[] commands = {
            "START",
            new String("stop"),
            "  Pause  ",
            "RUN",
            "   ",
            null
        };

        for (int i = 0; i < commands.length; i++) {
            System.out.println(commands[i] + " -> " + isValidCommand(commands[i]));
        }
    }

    public static boolean isValidCommand(String command) {
        if (command == null) {
            return false;
        }

        String cleaned = command.trim().toUpperCase();
        return cleaned.equals("START") || cleaned.equals("STOP") || cleaned.equals("PAUSE");
    }
}