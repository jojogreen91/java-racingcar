package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.random.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream()
                .map(name -> new Car(name))
                .collect(toList());
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            moveOneCar(randomNumberGenerator, car);
        }
    }

    private void moveOneCar(RandomNumberGenerator randomNumberGenerator, Car car) {
        if (randomNumberGenerator.isMoveAvailable()) {
            car.forwardCarPosition();
        }
    }

    public List<Car> cloneCarList() {
        List<Car> carsClone = new ArrayList<>();
        for (Car car : cars) {
            carsClone.add(car.clone());
        }
        return carsClone;
    }
}
