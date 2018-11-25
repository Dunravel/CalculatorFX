package sample;

public class HistoryEntry {
    private String description;
    private double number;
    private Operation operation;

    public HistoryEntry(String description, Operation operation, double number){
        this.description = description;
        this.operation = operation;
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return description + " - operation: " + operation + " - current number " + number;
    }
}
