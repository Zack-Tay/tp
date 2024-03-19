package seedu.address.model.module;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;

import seedu.address.model.person.Person;

/**
 * Represents a Module's tutorial class code.
 * Guarantees: immutable; is valid as declared in {@link #isValidTutorialClass(String)}
 */
public class TutorialClass {

    public static final String MESSAGE_CONSTRAINTS =
        "Please enter a valid NUS tutorial class code eg. T01, and it should not be blank";

    /**
     * This regex validates the tutorial class code that user enters.
     * Supports format like "L07", "T01" and "T015".
     */
    public static final String VALIDATION_REGEX = "^[A-Z]\\d{2}$";

    public final String tutorialName;
    private final ArrayList<Person> students;

    /**
     * A constructor for TutorialClass. Creates an empty tutorial class with no students.
     *
     * @param tutorialClass of tutorial to be added
     */
    public TutorialClass(String tutorialClass) {
        requireAllNonNull(tutorialClass);
        checkArgument(isValidTutorialClass(tutorialClass), MESSAGE_CONSTRAINTS);
        this.tutorialName = tutorialClass;
        this.students = new ArrayList<>();
    }

    /**
     * A constructor for TutorialClass. Creates a tutorial with the list of students specified.
     *
     * @param tutorialClass of tutorial to be added
     * @param students to be in the added tutorial
     */
    public TutorialClass(String tutorialClass, ArrayList<Person> students) {
        requireAllNonNull(tutorialClass);
        checkArgument(isValidTutorialClass(tutorialClass), MESSAGE_CONSTRAINTS);
        this.tutorialName = tutorialClass;
        this.students = students;
    }

    /**
     * Returns true if a given string is a valid tutorial class code.
     */
    public static boolean isValidTutorialClass(String test) {
        return test.matches(VALIDATION_REGEX);
    }
    public TutorialClass getTutorialClass() {
        return this;
    }
    public ArrayList<Person> getStudents() {
        return this.students;
    }

    @Override
    public String toString() {
        return tutorialName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TutorialClass)) {
            return false;
        }

        TutorialClass otherTutorialClass = (TutorialClass) other;
        return tutorialName.equals(otherTutorialClass.tutorialName);
    }

    @Override
    public int hashCode() {
        return tutorialName.hashCode();
    }
}