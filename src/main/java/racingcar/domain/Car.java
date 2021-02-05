package racingcar.domain;

import racingcar.constant.Digit;
import racingcar.constant.Message;

public class Car {
    private final String name;
    private final int position;

    public Car(String name, int position) {
        validateLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateLength(String name) {
        if ((name.length() < Digit.MINIMUM_CAR_NAME_LENGTH.getDigit())
                || (name.length() > Digit.MAXIMUM_CAR_NAME_LENGTH.getDigit())) {
            throw new IllegalArgumentException(Message.CAR_NAME_LENGTH_ERROR.toString());
        }
    }
}
