import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    State soldOutState;
    State soldState;
    State hasQuaterState;
    State noQuarterState;
    State winnerState;

    State state;

    private int cnt;
//    private final String location;
    @Serial
    private static final long serialVersionUID = 2L;

    public GumballMachine(int cnt) throws RemoteException{

        soldOutState = new SoldOutState();
        soldState = new SoldState(this);
        hasQuaterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);

        this.cnt = cnt;
//        this.location = location;
        if (cnt > 0) {
            state = noQuarterState;
        } else state = soldOutState;

    }

    public void gumballMachineState() {
        System.out.println("---------------------------");
        System.out.println("주식회사 왕뽑기");
        System.out.println("자바로 돌아가는 최신형 뽑기 기계");
        System.out.println("남은 개수 : " + cnt + "개");
        if(cnt != 0)
            System.out.println("동전 투입 대기중");
        else System.out.println("매진");
        System.out.println();

    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
       state.turnCrank();
       state.dispense();
    }

    void releaseBall() {
        System.out.println("알맹이 내보내는 중");
        if (cnt > 0) {
            cnt--;
        }
    }

    public int decreaseCount() {
        return cnt--;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getHasQuaterState() {
        return hasQuaterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public boolean isCountZero() {
        return cnt == 0;
    }

    public boolean isCountPositive() {
        return cnt > 0;
    }

    public int getCnt() {
        return cnt;
    }

    @Override
    public int getCount() throws RemoteException {
        return cnt;
    }

    public String getLocation() throws RemoteException{
//        return location;
        return null;
    }

    public State getState() throws RemoteException{
        return state;
    }
}
