package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorView implements CalculatorMVC.View{

    @FXML
    Label count_label;
    CalculatorMVC.Controller controller = new CalculatorController(this);

    @FXML
    public void onAddButtonClicked(){
        controller.operation(Operation.ADD);
    }

    @FXML
    public void onSubButtonClicked(){
        controller.operation(Operation.SUBSTRACT);
    }

    @FXML
    public void onMultiplyButtonClicked(){
        controller.operation(Operation.MULTIPLY);
    }

    @FXML
    public void onDivideButtonClicked(){
        controller.operation(Operation.DIVIDE);
    }
    @FXML
    public void onCalculateButtonClicked(){
        controller.result();
    }

    @FXML
    public void onClearButtonClicked(){
        controller.clear();
    }
    @FXML
    public void onOneButtonClicked(){
        controller.numberEntry(1);

    }

    @FXML
    public void onTwoButtonClicked(){
        controller.numberEntry(2);

    }

    @FXML
    public void onThreeButtonClicked(){
        controller.numberEntry(3);

    }

    @FXML
    public void onFourButtonClicked(){
        controller.numberEntry(4);

    }

    @FXML
    public void onFiveButtonClicked(){
        controller.numberEntry(5);

    }

    @FXML
    public void onSixButtonClicked(){
        controller.numberEntry(6);

    }

    @FXML
    public void onSevenButtonClicked(){
        controller.numberEntry(7);

    }

    @FXML
    public void onEightButtonClicked(){
        controller.numberEntry(8);

    }

    @FXML
    public void onNineButtonClicked(){
        controller.numberEntry(9);

    }

    @FXML
    public void onZeroButtonClicked(){
        controller.numberEntry(0);

    }

    @Override
    public void setCounterText(int counter) {
        count_label.setText(counter + "");
    }

    @Override
    public void setCounterText(double counter) {
        count_label.setText(counter + "");
    }


}
