package fominskiy.persist;

public class ExcData {
    private String firstColumn;
    private String secondColumn;

    public ExcData(String fColumn, String sColumn) {
        this.firstColumn = fColumn;
        this.secondColumn = sColumn;
    }

    public ExcData() {}

    public String getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(String firstColumn) {
        this.firstColumn = firstColumn;
    }

    public String getSecondColumn() {
        return secondColumn;
    }

    public void setSecondColumn(String secondColumn) {
        this.secondColumn = secondColumn;
    }
}
