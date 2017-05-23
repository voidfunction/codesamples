/**
 * Created by ltian on 5/23/2017.
 */
public class InterfactUtils {

    public static void utils(String[] args) {
        // list of useful interface of IntelliJ
        com.intellij.ide.plugins.PluginManager pluginManager;
        com.intellij.openapi.actionSystem.ActionManager actionManager;
        com.intellij.openapi.compiler.CompilerManager compilerManager;
        com.intellij.notification.NotificationsManager notificationsManager;
        com.intellij.openapi.application.ApplicationManager applicationManager;
        com.intellij.configurationStore.ApplicationStorageManager applicationStorageManager;
        com.intellij.ide.ApplicationActivationStateManager applicationActivationStateManager;

        com.intellij.openapi.project.ProjectManager projectManager;
        com.intellij.openapi.project.ProjectUtil.guessProjectForFile(null);
        com.intellij.openapi.application.PathManager pathManager;
        com.intellij.openapi.application.PluginPathManager pluginPathManager;

        com.intellij.openapi.components.ServiceManager serviceManager;
        com.intellij.openapi.components.StoragePathMacros storagePathMacros; // path types
        com.intellij.openapi.components.ComponentManager componentManager;

        com.intellij.openapi.file.exclude.ProjectPlainTextFileTypeManager projectPlainTextFileTypeManager;
        com.intellij.openapi.file.exclude.EnforcedPlainTextFileTypeManager enforcedPlainTextFileTypeManager;
        com.intellij.openapi.fileTypes.FileTypeManager fileTypeManager;
        com.intellij.openapi.fileTypes.MockFileTypeManager mockFileTypeManager;

        com.intellij.openapi.fileChooser.FileChooser fileChooser;
        com.intellij.core.CoreModuleManager coreModuleManager;
        com.intellij.openapi.roots.ui.configuration.ProjectConfigurable projectConfigurable;
        com.intellij.openapi.roots.ui.configuration.ProjectStructureConfigurable projectStructureConfigurable;

        com.intellij.util.PlatformUtils.isPyCharm(); // get IDE type
    }

}
