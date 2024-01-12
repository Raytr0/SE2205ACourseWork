package L7Q1;

public class RyanValueEntry {
    private Integer key;
    public RyanValueEntry(){
        key = -1;
    }

    public RyanValueEntry(Integer key){
        this.key = key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
    public String toString() {
        if (this.key == -1) {
            return "null";
        } else if (this.key == -111) {
            return "available";
        }else{
            return String.format("%d", this.key);
        }
    }
}
