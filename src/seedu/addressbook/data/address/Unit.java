package seedu.addressbook.data.address;

public class Unit {
    public String value;

    public Unit(String unit) {
        this.value = unit;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
