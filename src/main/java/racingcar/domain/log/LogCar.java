package racingcar.domain.log;

public class LogCar {

    private String name;
    private int position;

    public LogCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
