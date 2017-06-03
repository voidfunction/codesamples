package my.sample.jackson;

/**
 * Created by ltian on 6/3/2017.
 */
public  class MyObject {
    private String key;
    private String value;

    public MyObject() {

    }
    public MyObject(String k, String v) {
        this.key = k;
        this.value = v;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
