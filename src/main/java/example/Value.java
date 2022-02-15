package example;

public class Value {
    String key, value;
    Integer row, column;
    Enum position;

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

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Enum getPosition() {
        return position;
    }

    public void setPosition(Enum position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Value{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", row=" + row +
                ", column=" + column +
                ", pozitie=" + position +
                '}';
    }
}
