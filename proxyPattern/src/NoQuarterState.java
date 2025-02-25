import java.io.Serial;

public class NoQuarterState implements State {

    @Serial
    private static final long serialVersionUID = 2L;
    //@serial?

    transient private final GumballMachine gumballMachine;
    // transient?

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        gumballMachine.setState(gumballMachine.getHasQuaterState());
        System.out.println("동전을 넣으셨습니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전을 넣어주세요");
    }

    @Override
    public void turnCrank() {
        System.out.println("동전을 넣어주세요");

    }
    @Override
    public void dispense() {
        System.out.println("동전을 넣어주세요");
    }
}
