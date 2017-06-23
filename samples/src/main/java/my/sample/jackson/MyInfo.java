package my.sample.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ltian on 6/12/2017.
 */
public class MyInfo {

    @JsonProperty("Home Address")
    private String address;

    @JsonProperty("Local People")
    private boolean isLocal;

    @JsonProperty("Own ID")
    private int id;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
