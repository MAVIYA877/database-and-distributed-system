class Server {

    private String name;

    public Server(String name) {
        this.name = name;
    }

    public void handle(String request) {
        System.out.println(name + " handled " + request);
    }
}

public class LoadBalancer {

    private Server[] servers;
    private int current = 0;

    public LoadBalancer(Server[] servers) {
        this.servers = servers;
    }

    public void sendRequest(String request) {
        servers[current].handle(request);
        current = (current + 1) % servers.length;
    }

    public static void main(String[] args) {
        Server[] servers = {
                new Server("Server-1"),
                new Server("Server-2"),
                new Server("Server-3")
        };

        LoadBalancer loadBalancer = new LoadBalancer(servers);

        for (int i = 1; i <= 10; i++) {
            loadBalancer.sendRequest("Request-" + i);
        }
    }
}