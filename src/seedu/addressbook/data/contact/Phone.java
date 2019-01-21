package seedu.addressbook.data.contact;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Phone extends Contact {

    public static final String EXAMPLE = "123456789";
    public static final String MESSAGE_CONSTRAINTS = "Person phone numbers should only contain numbers";
    public static final String VALIDATION_REGEX = "\\d+";

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Phone(String phone, boolean isPrivate) throws IllegalValueException {
        super(phone, isPrivate);

        if (!isValid(this.value)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Returns true if the given string is a valid person email.
     */
    public static boolean isValid(String test) {
        return test.matches(VALIDATION_REGEX);
    }
}
