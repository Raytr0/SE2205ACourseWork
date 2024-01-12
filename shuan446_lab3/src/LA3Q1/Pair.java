package LA3Q1;

public class Pair<Y,N> {
    private Y key;
    private N value;

    public Pair() {}

    public Pair(Y key, N value){
        this.key = key;
        this.value = value;
    }
    //Setter Methods
    public void setKey(Y key) {
        this.key = key;
    }

    public void setValue(N value) {
        this.value = value;
    }
    //Getter Methods
    public Y getKey() {
        return key;
    }

    public N getValue() {
        return value;
    }
    //Overrides toString with the given return string
    @Override
    public String toString() {
        return "[YR: " + key + ", NM: " + value + "]";
    }
}
