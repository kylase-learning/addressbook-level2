package seedu.addressbook.data.contact;

import seedu.addressbook.data.Printable;

abstract class Contact implements Printable {
    public String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) {
        this.value = value.trim();
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String getPrintableString() {
        return getClass().getSimpleName() + ": " + this.value;
    }

    @Override
    public String getPrintableString(Printable... printables) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
