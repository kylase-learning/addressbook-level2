package seedu.addressbook.data.address;

public class Street {
    public String value;

    public Street(String street) {
        this.value = street;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
