public class winnerState implements State {

    private final GumballMachine gumballMachine;

    public winnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("알맹이 내보내는 중");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("이미 알맹이 뽑으셨습니다.");

    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한 번만 돌려주세ㅐ요.");

    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.isCountZero()) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            System.out.println("축하합니다. 알맹이를 하나 더 받으실 수 있습니다.");
        }
        if (gumballMachine.isCountPositive()) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("알맹이가 없어요");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
