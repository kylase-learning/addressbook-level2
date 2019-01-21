package seedu.addressbook.data.contact;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Email extends Contact{

    public static final String EXAMPLE = "valid@e.mail";
    public static final String MESSAGE_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email, boolean isPrivate) throws IllegalValueException {
        super(email, isPrivate);

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
