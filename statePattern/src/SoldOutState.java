public class SoldOutState implements State {

    @Override
    public void insertQuarter() {
        System.out.println("매진");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전을 넣지 않았습니다. 반환되지 않습니다.");

    }

    @Override
    public void turnCrank() {
        System.out.println("매진");

    }

    @Override
    public void dispense() {
        System.out.println("매진");

    }
}
