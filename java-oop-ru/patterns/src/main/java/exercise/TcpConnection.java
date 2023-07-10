package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

public class TcpConnection implements Connection {
    private String ip;
    private int port;
    private Connection currentState;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.currentState = new Connected(this);
        
    }

    @Override
    public String getCurrentState() {
        return currentState.getCurrentState();
    }

    public void setCurrentState(Connection connection) {
        this.currentState = connection;
    }

    @Override
    public void connect() {
        currentState.connect();
    }

    @Override
    public void disconnect() {
        currentState.disconnect();
    }

    @Override
    public void write(String data) {
        currentState.write(data);
    }



}