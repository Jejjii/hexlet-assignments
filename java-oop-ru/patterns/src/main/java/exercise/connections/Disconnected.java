package exercise.connections;

import exercise.TcpConnection;

public class Disconnected implements Connection {
    private TcpConnection connection;

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }
    @Override
    public void write(String data) {
        System.out.println("Error! Cannot write data when connection is disconnected");
    }

    public String getCurrentState() {
        return "disconnected";
    }
    @Override
    public void connect() {
        connection.setCurrentState(new Connected(connection));
    }
    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconnected");
    }

}
