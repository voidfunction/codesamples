package com.ltian.plugins;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ltian on 5/22/2017.
 */
@State(
        name = "MyProjectService",
        storages = {
//                @Storage(id = "com.ltian.plugin.sampls", file = "$PROJECT_FILE$"),
                @Storage(file = "$PROJECT_CONFIG_DIR$/mySetting.xml", scheme = StorageScheme.DIRECTORY_BASED)
        }
)
public class MyApplicationService implements PersistentStateComponent<MyApplicationService.State> {

    private State myState = new State();

    @Nullable
    @Override
    public State getState() {
        return myState;
    }

    @Override
    public void loadState(State state) {
        XmlSerializerUtil.copyBean(state, myState);
    }

    @Override
    public void noStateLoaded() {

    }

    public String getCurrentId() {
        return myState.currentId;
    }
    public void setCurrentId(String id) {
        myState.currentId = id;
    }
    public String getProperty(@NotNull String key) {
        return myState.properties.get(key);
    }

    public void setProperty(@NotNull String key, @NotNull String value) {
        myState.properties.put(key, value);
    }

    public static class State {
        public String currentId;
        public Map<String, String> properties = new HashMap<String, String>();
    }
}
