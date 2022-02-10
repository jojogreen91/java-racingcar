package racingcar.parser;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import racingcar.parser.exception.CarNameException;

public class CarNameParser {

    public List<String> parse(String names) {
        validateCarNames(names);

        return Arrays.stream(splitByComma(names))
            .collect(toList());
    }

    private void validateCarNames(String names) {
        checkNameLength(names);
        checkEmptyName(names);
        checkDuplicateName(names);
    }

    private void checkNameLength(String names) {
        if (isInvalidLength(names)) {
            throw new CarNameException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private void checkEmptyName(String names) {
        if (isEmptyName(names)) {
            throw new CarNameException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void checkDuplicateName(String names) {
        if (isDuplicateName(names)) {
            throw new CarNameException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    private boolean isInvalidLength(String names) {
        return Arrays.stream(splitByComma(names))
            .anyMatch(n -> n.length() > 5);
    }

    private boolean isEmptyName(String names) {
        return Arrays.stream(splitByComma(names)).anyMatch(String::isEmpty);
    }

    private boolean isDuplicateName(String names) {
        return Arrays.stream(splitByComma(names)).distinct().count() != splitByComma(names).length;
    }

    private String[] splitByComma(String names) {
        return names.split(",");
    }
}
