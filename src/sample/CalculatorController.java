package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorController implements CalculatorMVC.Controller {
    private CalculatorMVC.View view;
    private double counter = 0;
    private double firstNumber = 0;

    private Operation operation;
    private List<String> calculationHistory = new ArrayList<>();

    public CalculatorController(CalculatorMVC.View view){
        this.view = view;
    }

    @Override
    public void addOperation() {
        resetCounter();
        setOperation(Operation.ADD);

    }

    private void setOperation(Operation operation) {
        this.operation = operation;
        addHistory(operation);
    }

    private void addHistory(Operation operation) {
        calculationHistory.add("Operation selected: " + operation);
    }

    @Override
    public void subOperation() {
        setOperation(Operation.SUBSTRACT);
        resetCounter();
    }

    @Override
    public void multiplyOperation() {
        setOperation(Operation.MULTIPLY);
        resetCounter();
    }

    @Override
    public void divideOperation() {
        setOperation(Operation.DIVIDE);
        resetCounter();
    }


    private void resetCounter() {
        firstNumber += counter;
        addHistory(counter);
        counter = 0;
        view.setCounterText(0);
    }

    private void addHistory(double number) {
        calculationHistory.add("Number entered: " + number );
    }


    @Override
    public void result(){
        addHistory(counter);
        if(operation == Operation.ADD){
            counter = firstNumber + counter;
        }else if(operation == Operation.SUBSTRACT){
            counter = firstNumber - counter;
        } else if(operation == Operation.MULTIPLY){
            counter = firstNumber * counter;
        } else if(operation == Operation.DIVIDE){
            counter = firstNumber / counter;
        }
        firstNumber =0;
        view.setCounterText(counter);
        setOperation(Operation.CALCULATE);
        addResultToHistory(counter);
        System.out.println(Arrays.toString(calculationHistory.toArray()));
    }

    private void addResultToHistory(double result) {
        calculationHistory.add("Result: " + result);
    }

    @Override
    public void numberEntry(int number) {
        clear();

        if (counter == 0){
            counter = number;
        } else {
            counter = counter*10 + number;
        }
        view.setCounterText(counter);
    }

    @Override
    public void clear() {

        if(operation == Operation.CALCULATE) {
            setOperation(Operation.CLEAR);
            counter = 0;
            firstNumber = 0;
            addHistory(Operation.CLEAR);
            view.setCounterText(0);
        }
    }

}
