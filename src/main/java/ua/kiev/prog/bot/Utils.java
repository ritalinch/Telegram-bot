package ua.kiev.prog.bot;

import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.GenericValidator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {

    public static boolean isValidEmailAddress(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public static boolean isBirthDateValid(String date) {
        try {
            return getLocalDateFromString(date).isBefore(LocalDate.now())
                    && GenericValidator.isDate(
                    date,
                    "yyyy-MM-dd",
                    true
            );
        } catch (RuntimeException e) {
            return false;
        }

    }

    public static LocalDate getLocalDateFromString(String date) {
        try {
            final var args = Arrays.stream(date.split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return LocalDate.of(args.get(0), args.get(1), args.get(2));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
