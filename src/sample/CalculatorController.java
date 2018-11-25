package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorController implements CalculatorMVC.Controller {
    private CalculatorMVC.View view;
    private double counter = 0;
    private double currentResult = 0;

    private Operation operation;
    private List<String> calculationHistory = new ArrayList<>();
    private List<HistoryEntry> history = new ArrayList<>();

    public CalculatorController(CalculatorMVC.View view){
        this.view = view;
    }

    @Override
    public void operation(Operation operation) {
        resetCounter();
        setOperation(operation);
    }

    @Override
    public void result(){
        addHistory(counter);

        switch (operation){

            case ADD:
                currentResult = currentResult + counter;
                break;
            case SUBSTRACT:
                currentResult = currentResult - counter;
                break;
            case MULTIPLY:
                currentResult = currentResult * counter;
                break;
            case DIVIDE:
                currentResult = currentResult / counter;
                break;
        }

        counter = 0;
        view.setCounterText(currentResult);
        setOperation(Operation.CALCULATE);
        addResultToHistory(currentResult);
        System.out.println(Arrays.toString(calculationHistory.toArray()));
      //  System.out.println(Arrays.toString(history.toArray()));
    }

    @Override
    public void numberEntry(int number) {
        clearAfterResult();
        if (counter == 0){
            counter = number;
        } else {
            counter = counter*10 + number;
        }
        view.setCounterText(counter);
    }

    @Override
    public void clear() {
            setOperation(Operation.CLEAR);
            counter = 0;
            currentResult = 0;
            view.setCounterText(currentResult);
    }

    public void clearAfterResult(){
        if(operation == Operation.CALCULATE) {
            clear();
        }
    }




    private void resetCounter() {
        currentResult += counter;
        addHistory(counter);
        counter = 0;
        view.setCounterText(counter);
    }

    private void setOperation(Operation operation) {
        this.operation = operation;
        addOperationHistory(operation);
    }

    private void addOperationHistory(Operation operation) {
        calculationHistory.add("Operation selected: " + operation);
        history.add(new HistoryEntry("Operation selected: ", operation, currentResult));
    }

    private void addHistory(double number) {
        calculationHistory.add("Number entered: " + number );
        history.add(new HistoryEntry("Number entered: ", operation, number));
    }

    private void addResultToHistory(double result) {
        calculationHistory.add("Result: " + result);
        history.add(new HistoryEntry("Result: ", operation,result));
    }



}
