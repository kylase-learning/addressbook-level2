package seedu.addressbook.data;

public interface Printable {
    String getPrintableString();
    String getPrintableString(Printable...printables);
}
