package seedu.addressbook.data;

public interface Printable {
    /**
     *
     * @return
     */
    String getPrintableString();

    /**
     * Returns a concatenated version of the printable string of each object.
     * @param printables
     * @return String
     */
    default String getPrintableString(Printable...printables) {
        StringBuilder concatenatedString = new StringBuilder();

        for (Printable p: printables) {
            concatenatedString.append(", ");
            concatenatedString.append(p.getPrintableString());
        }

        return concatenatedString.toString();
    };
}
