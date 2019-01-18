package seedu.addressbook.data.address;

public class PostalCode {
    public String value;

    public PostalCode(String postalCode) {
        this.value = postalCode;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
