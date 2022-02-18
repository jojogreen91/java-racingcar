package racingcar.domain.log;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameLog {

    private final Map<Integer, List<CarForLog>> gameLog;

    public GameLog() {
        this.gameLog = new HashMap<>();
    }

    public void writeLog(int currentTryCount, Cars currentCars) {
        gameLog.put(currentTryCount, getLogCarList(currentCars));
    }

    private List<CarForLog> getLogCarList(Cars cars) {
        List<CarForLog> carForLogList = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carForLogList.add(new CarForLog(car.getName(), car.getPosition()));
        }
        return carForLogList;
    }

    public List<CarForLog> getLog(int tryCount) {
        return gameLog.get(tryCount);
    }

    public int getPositionByName(int tryCount, String name) {
        return findCarByName(tryCount, name).getPosition();
    }

    private CarForLog findCarByName(int tryCount, String name) {
        return getLog(tryCount).stream()
                .filter(carForLog -> carForLog.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    public List<String> getWinnerCarNames(int totalTryCount) {
        List<CarForLog> carForLogList = getLog(totalTryCount);
        int mostFarPosition = getMostFarPosition(carForLogList);
        return carForLogList.stream()
                .filter(car -> car.isSamePosition(mostFarPosition))
                .map(CarForLog::getName)
                .collect(toList());
    }

    private int getMostFarPosition(List<CarForLog> carList) {
        return carList.stream()
                .mapToInt(CarForLog::getPosition)
                .max()
                .orElseThrow();
    }
}
