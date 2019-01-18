package seedu.addressbook.data.address;

public class Block {
    public String value;

    public Block(String block) {
        this.value = block;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
