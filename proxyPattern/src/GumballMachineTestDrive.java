import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTestDrive {

    public static void main(String[] args) throws RemoteException {
        GumballMachine gumballMachine = new GumballMachine(5);

        gumballMachine.gumballMachineState(); // 기계의 상태를 출력

        gumballMachine.insertQuarter(); // 동전을 넣음
        gumballMachine.turnCrank(); // 손잡이를 돌림

        gumballMachine.gumballMachineState(); // 기계의 상태를 출력

        gumballMachine.insertQuarter(); // 동전을 넣음
        gumballMachine.turnCrank(); // 손잡이를 돌림
        gumballMachine.insertQuarter(); // 동전을 넣음
        gumballMachine.turnCrank(); // 손잡이를 돌림

        gumballMachine.gumballMachineState(); // 기계의 상태를 출력

        /* GumballMachine gumballMachine = null;
        int cnt = 0;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        try {
            cnt = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(cnt, args[0]);
            Naming.rebind("rmi://127.0.0.1/gumballmachine", gumballMachine);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }*/
    }
}