package io.solidcheck;

import io.solidcheck.commands.AuditCommand;
import io.solidcheck.commands.GenerateSampleFiles;
import io.solidcheck.commands.GenerateTestsCommand;
import io.solidcheck.commands.InstallCommand;
import io.solidcheck.commands.InteractiveModeCommand;
import io.solidcheck.commands.ListCommand;
import io.solidcheck.commands.NoSuchCommand;
import io.solidcheck.commands.ViewReportCommand;
import io.solidcheck.config.CommandNames;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class AuditMaster {

    public static void main(String[] args) {
        printShield();
        boolean shouldRun = true;
        while(shouldRun) {
            System.out.print("__ ");
            Scanner scanner = new Scanner(System.in);
            // to make more testable, should return string and boolean result, and then print it here
            shouldRun = callCommand(parseCommand(scanner.nextLine()));
        }
    }

    public static Command parseCommand(String commandFull) {
        Command command = new Command();
        if(commandFull.split("\\s").length > 1) {
            String[] allTerms = commandFull.split("\\s");
            command.commandMain = commandFull.split("\\s")[0];
            command.commandArgs = (String[])Arrays.asList(commandFull.split("\\s"))
                                                  .stream().skip(1).collect(Collectors.toList()).toArray(new String[allTerms.length-1]);

        }
        else
            command.commandMain = commandFull;
        return command;
    }

    public static boolean callCommand(Command command) {
        boolean result = true;
        Class clazzToCall = null;

        switch(command.commandMain) {
            case CommandNames.LIST_COMMAND: { clazzToCall = ListCommand.class;break;}
            case CommandNames.INSTALL_COMMAND: { clazzToCall = InstallCommand.class;break;}
            case CommandNames.AUDIT_COMMAND: { clazzToCall = AuditCommand.class;break;}
            case CommandNames.GENERATE_SAMPLES: {clazzToCall = GenerateSampleFiles.class;break;}
            case CommandNames.INTERACTIVE_MODE: {clazzToCall = InteractiveModeCommand.class;break;}
            case CommandNames.VIEW_REPORT: { clazzToCall = ViewReportCommand.class; break;}
            case CommandNames.GENERATE_TESTS: { clazzToCall = GenerateTestsCommand.class; break;}
            case CommandNames.QUIT_COMMAND: { result = false; break;}
            default: {clazzToCall = NoSuchCommand.class; break;}
        }

        String[] ss = new String[0];
        if(clazzToCall!=null) {
            try {
                CommandLine.call((Callable) clazzToCall.getConstructors()[0].newInstance(), command.commandArgs);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }

    private static void printShield() {
        System.out.println("\n" +
                "   _____       _ _     _  _____ _               _    \n" +
                "  / ____|     | (_)   | |/ ____| |             | |   \n" +
                " | (___   ___ | |_  __| | |    | |__   ___  ___| | __\n" +
                "  \\___ \\ / _ \\| | |/ _` | |    | '_ \\ / _ \\/ __| |/ /\n" +
                "  ____) | (_) | | | (_| | |____| | | |  __/ (__|   < \n" +
                " |_____/ \\___/|_|_|\\__,_|\\_____|_| |_|\\___|\\___|_|\\_\\\n" +
                "                                                     \n" +
                "                                                     \n");
        System.out.println("\\_________________/\n" +
                "|       | |       |\n" +
                "|       | |       |\n" +
                "|       | |       |\n" +
                "|_______| |_______|\n" +
                "|_______   _______|\n" +
                "|       | |       |\n" +
                "|       | |       |\n" +
                " \\      | |      /\n" +
                "  \\     | |     /\n" +
                "   \\    | |    /\n" +
                "    \\   | |   /\n" +
                "     \\  | |  /\n" +
                "      \\ | | /\n" +
                "       \\| |/\n" +
                "        \\_/");
    }

}
