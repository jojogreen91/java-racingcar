package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void forwardCarPosition() {
        position++;
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
