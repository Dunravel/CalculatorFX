package sample;

public interface CalculatorMVC {

    interface View{
        void setCounterText(int counter);
        void setCounterText(double counter);
    }

    interface  Controller{
        void operation(Operation operation);

        void result();

        void numberEntry(int number);

        void clear();
    }
}
