package engine;

public class ServerResp {
    public boolean success;
    public String feedback;

    public ServerResp(boolean success,String feedback){
        this.success = success;
        this.feedback = feedback;
    }
}
