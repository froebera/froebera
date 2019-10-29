package froebera.dadjokes.service.model;

public class JokeResponse {
    public String id;
    public String joke;
    public String status;

    @Override
    public String toString() {
        return "JokeResponse{" +
                "id='" + id + '\'' +
                ", joke='" + joke + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
