package Q1LE2;

public class Pair<Y,N> {
    private Y key;
    private N value;

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
}
