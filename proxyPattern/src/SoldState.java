public class SoldState implements State {

    private final GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
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
        System.out.println("알맹이를 내보내고 있습니다.");
        int cnt = gumballMachine.decreaseCount();
        if(cnt == 0) {
            System.out.println("알맹이 X");
           gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
