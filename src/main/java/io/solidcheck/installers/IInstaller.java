package io.solidcheck.installers;

public interface IInstaller {

    boolean isAlreadyInstalled(String engine);
    boolean hasAllPrerequisites(String engine);
    boolean performInstall(String engine);

}
