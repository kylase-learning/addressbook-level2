package seedu.addressbook.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

public enum Formatter {
    MESSAGES {
        @Override
        public void show(String...messages) {
            printMessages(messages);
        }
    },
    MESSAGES_WITH_PREFIX {
        @Override
        public void show(String... messages) {
            ArrayList<String> template = new ArrayList<>(Collections.singletonList(LINE_PREFIX));
            Collections.addAll(template, messages);
            printMessages(template.toArray(new String[0]));
        }
    },
    MESSAGES_WITH_DIVIDER {
        @Override
        public void show(String... messages) {
            ArrayList<String> template = new ArrayList<>(Arrays.asList(messages));
            template.add(DIVIDER);
            printMessages(template.toArray(new String[0]));
        }
    },
    WELCOME {
        @Override
        public void show(String... messages) {
            String version = messages[0];
            String storageFilePath = messages[1];

            String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);

            String[] template = {DIVIDER, DIVIDER, MESSAGE_WELCOME,
                    version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER};

            printMessages(template);
        }
    },
    GOODBYE {
        @Override
        public void show(String... messages) {
            String[] template = {MESSAGE_GOODBYE, DIVIDER, DIVIDER};

            printMessages(template);
        }
    },
    INIT_FAILED {
        @Override
        public void show(String... messages) {
            String[] template = {MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};

            printMessages(template);
        }
    };

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    private static void printMessages(String[] messages) {
        for (String m: messages) {
            System.out.println(LINE_PREFIX + m.replace("\n", LS +LINE_PREFIX));
        }
    }

    abstract public void show(String...messages);
}
