package sample;

public interface CalculatorMVC {

    interface View{
        void setCounterText(int counter);
        void setCounterText(double counter);
    }

    interface  Controller{
        void addOperation();
        void subOperation();

        void multiplyOperation();

        void divideOperation();

        void result();

        void numberEntry(int number);

        void clear();
    }
}
