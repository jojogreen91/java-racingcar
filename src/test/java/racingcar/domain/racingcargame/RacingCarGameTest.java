package racingcar.domain.racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.*;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @DisplayName("주어진 횟수만큼 자동차 경주를 실행하는 기능을 테스트한다.")
    @Test
    void testExecute() {
        //given
        Cars cars = new Cars(Arrays.asList(
                new Car("benz"), new Car("test")
        ));
        TryNumber tryNumber = new TryNumber(5);
        FixedMovingStrategy fixedMovingStrategy = new FixedMovingStrategy(4);

        //when
        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);
        List<Cars> runResult = racingCarGame.execute(fixedMovingStrategy);
        List<Car> playedCars = runResult.get(4).getCars();

        //then
        assertThat(playedCars.get(0))
                .isEqualTo(new Car("benz", 5));
        assertThat(playedCars.get(1))
                .isEqualTo(new Car("test", 5));

    }

    @DisplayName("우승자를 찾는 기능을 테스트한다")
    @Test
    void testFindWinners() {
        //given
        Cars playedCars = new Cars(Arrays.asList(
                new Car("benz", 3),
                new Car("kia", 1),
                new Car("bmw", 0)
        ));
        TryNumber tryNumber = new TryNumber(1);

        //when
        RacingCarGame racingCarGame = new RacingCarGame(playedCars, tryNumber);
        List<Car> cars = racingCarGame.findWinners();

        //then
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0)).isEqualTo(new Car("benz", 3));
    }
}