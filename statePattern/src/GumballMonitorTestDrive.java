import java.rmi.*;

public class GumballMonitorTestDrive {

    public static void main(String[] args) throws RemoteException {
        // 모니터링할 위치를 배열로 저장
        String[] location = {
                "rmi://127.0.0.1/gumballmachine"
        };

        // GumballMonitor 배열 생성
        GumballMonitor[] monitor = new GumballMonitor[location.length];

        // 각 위치에 있는 기계를 찾아 모니터에 등록
        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 순환문을 돌면서 각 기계로부터 보고서 출력
        for (int i = 0; i < monitor.length; i++) {
            monitor[i].report();
        }
    }
}
