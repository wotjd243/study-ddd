package io.github.wotjd243.dddpokemon.calculator;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "6,3,9"})
    void add(final int num1, final int num2, final int expected) {
        final Calculator calculator = new Calculator();
        assertThat(calculator.add(num1, num2)).isEqualTo(expected);
    }

    private boolean isBlank(final String input) {
        return input == null || input.trim().isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(final int number) {
        final boolean odd = number % 2 != 0;
        assertThat(odd).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyInputs(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullAndEmptyInputs(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(final Month month) {
        final int value = month.getValue();
        assertThat(value).isBetween(1, 12);
    }

    @ParameterizedTest(name = "{index} {0} is 30 days long")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(final Month month) {
        final boolean isALeapYear = false;
        assertThat(month.length(isALeapYear)).isEqualTo(30);
    }

    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = EnumSource.Mode.EXCLUDE
    )
    void exceptFourMonths_OthersAre31DaysLong(final Month month) {
        final boolean isALeapYear = false;
        assertThat(month.length(isALeapYear)).isEqualTo(31);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    void fourMonths_AreEndingWithBer(final Month month) {
        final EnumSet<Month> months = EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertThat(months).contains(month);
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(final String input, final String expected) {
        final String actualValue = input.toUpperCase();
        assertThat(actualValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(final String input, final String expected) {
        final String actualValue = input.toLowerCase();
        assertThat(actualValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(final String input, final boolean expected) {
        assertThat(isBlank(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
        return Stream.of(null, "", "  ");
    }

    @ParameterizedTest
    @ArgumentsSource(BlankStringsArgumentsProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(final String input) {
        assertThat(isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"2018/12/25,2018", "2019/02/11,2019"})
    void getYear_ShouldWorkAsExpected(
            @ConvertWith(SlashyDateConverter.class) final LocalDate date,
            final int expected
    ) {
        assertThat(date.getYear()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"Isaac,,Newton,Isaac Newton", "Charles,Robert,Darwin,Charles Robert Darwin"})
    void fullName_ShouldGenerateTheExpectedFullName(final ArgumentsAccessor argumentsAccessor) {
        final String firstName = argumentsAccessor.getString(0);
        final String middleName = (String) argumentsAccessor.get(1);
        final String lastName = argumentsAccessor.get(2, String.class);
        final String expectedFullName = argumentsAccessor.getString(3);

        final Person person = new Person(firstName, middleName, lastName);
        assertThat(person.fullName()).isEqualTo(expectedFullName);
    }

    @ParameterizedTest
    @CsvSource({"Isaac Newton,Isaac,,Newton", "Charles Robert Darwin,Charles,Robert,Darwin"})
    void fullName_ShouldGenerateTheExpectedFullName(
            final String expectedFullName,
            @AggregateWith(PersonAggregator.class) final Person person
    ) {
        assertThat(person.fullName()).isEqualTo(expectedFullName);
    }
}

class BlankStringsArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of((String) null),
                Arguments.of(""),
                Arguments.of("  ")
        );
    }
}

class SlashyDateConverter implements ArgumentConverter {
    @Override
    public Object convert(final Object source, final ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new IllegalArgumentException("The argument should be a string: " + source);
        }
        try {
            String[] parts = ((String) source).split("/");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to convert", e);
        }
    }
}

class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Person(final String firstName, final String middleName, final String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String fullName() {
        if (middleName == null || middleName.trim().isEmpty()) {
            return String.format("%s %s", firstName, lastName);
        }

        return String.format("%s %s %s", firstName, middleName, lastName);
    }
}

class PersonAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(final ArgumentsAccessor accessor, final ParameterContext context) throws ArgumentsAggregationException {
        return new Person(accessor.getString(1), accessor.getString(2), accessor.getString(3));
    }
}
