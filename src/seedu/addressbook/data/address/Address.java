package seedu.addressbook.data.address;

import seedu.addressbook.data.Printable;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared ...}
 */
public class Address implements Printable {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in this format: BLOCK, STREET, UNIT, POSTALCODE";
    public static final Pattern ADDRESS_VALIDATION_REGEX = Pattern.compile("(?<block>.*),(?<street>.*),(?<unit>.*),(?<postalCode>.*)");

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();

        Matcher addressValidator = ADDRESS_VALIDATION_REGEX.matcher(trimmedAddress);

        this.isPrivate = isPrivate;
        if (!addressValidator.matches()) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.block = new Block(addressValidator.group("block").trim());
        this.street = new Street(addressValidator.group("street").trim());
        this.unit = new Unit(addressValidator.group("unit").trim());
        this.postalCode = new PostalCode(addressValidator.group("postalCode").trim());
    }

    private ArrayList<String> asArray() {
        ArrayList<String> components = new ArrayList<>();

        components.add(this.block.value);
        components.add(this.street.value);
        components.add(this.unit.value);
        components.add(this.postalCode.value);

        return components;
    }

    @Override
    public String toString() {
        return String.join(", ", this.asArray());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.value.equals(((Address) other).block.value)
                && this.street.value.equals(((Address) other).street.value)
                && this.unit.value.equals(((Address) other).unit.value)
                && this.postalCode.value.equals(((Address) other).postalCode.value)); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.block, this.street, this.unit, this.postalCode);
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String getPrintableString() {
        return getClass().getSimpleName() + ": " + this.toString();
    }

    @Override
    public String getPrintableString(Printable... printables) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
