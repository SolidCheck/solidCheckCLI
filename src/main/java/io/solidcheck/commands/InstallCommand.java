package io.solidcheck.commands;

import io.solidcheck.installers.IInstaller;
import io.solidcheck.runners.CheckIsInstalled;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Arrays;
import java.util.concurrent.Callable;

@Command(name = "install", description = "Installs audit and linting engines",
        version = "install 1.0", mixinStandardHelpOptions = true)
public class InstallCommand implements Callable<String> {

    @Option(names = {"-engine"},
            paramLabel = "engine",
            description = "Solidity audit/lint engine to install. " +
                          "Available options: " +
                          "- auditAll -- installs all audit engines, will take a while" +
                          "- mythril " +
                          "- slither " +
                          "- oyente " +
                          "- securify "+
                          "- smartCheck " +
                          "" +
                          "- lintingAll" +
                          "- surya"
    )
    private String engineToInstall = "";

    private String[] allEngines = {"mythril","slither", "oyente", "securify", "smartCheck"};

    IInstaller engineInstaller;

    public InstallCommand() {

    }

    @Override
    public String call() {
        System.out.println("Installing "+engineToInstall+" ...");

        switch(engineToInstall) {
            case "auditAll":    {
                installAllAuditEngines();
                break;
            }
            default: {
                try {
                    installEngine(engineToInstall);
                }
                catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return "";
    }

    private void installAllAuditEngines() {
        Arrays.asList(allEngines).stream().forEach(engineName -> {
            try {
                installEngine(engineName);
            }
            catch(InterruptedException e) {
                System.out.println("There has been an error installing engine "+engineName);
            }
        });
    }

    private void installEngine(String engineName) throws InterruptedException {
        System.out.println("Starting "+engineName+" install");
        Thread.sleep(50);
        System.out.println("Checking if "+ engineName+" is already installed");
        Thread.sleep(120);
        if(CheckIsInstalled.isInstalled(engineName)) {
            System.out.println(engineName + " already installed");
        }
        else {
            if(engineInstaller.hasAllPrerequisites(engineName))
                engineInstaller.performInstall(engineName);
        }
    }

    private boolean checkEngineInstalled(String engineName) {
        return true;
    }

}
