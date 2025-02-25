import java.rmi.RemoteException;

public class GumballMonitor {

    private final GumballMachineRemote gumballMachine;


    public GumballMonitor(GumballMachineRemote machineRemote) {
        this.gumballMachine = machineRemote;
    }

    public void report() throws RemoteException {
        try {
            System.out.println("gumballMachine.getLocation() = " + gumballMachine.getLocation());
            System.out.println("gumballMachine.getCnt() = " + gumballMachine.getCount() + " 개");
            System.out.println(gumballMachine.getState());
        } catch (Exception ignored) {
           ignored.printStackTrace();
        }
    }
}
