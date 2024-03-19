package seedu.address.model.module;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;

import seedu.address.model.person.Person;

/**
 * Represents a Module's tutorial class code.
 * Guarantees: immutable; is valid as declared in
 * {@link #isValidTutorialClass(String)}
 */
public class TutorialClass {

    public static final String MESSAGE_CONSTRAINTS = "Please enter a valid NUS tutorial class code "
            + "eg. T01, and it should not be blank";

    /**
     * This regex validates the tutorial class code that user enters.
     * Supports format like "L07", "T01" and "T015".
     */
    public static final String VALIDATION_REGEX = "^[A-Z]\\d{2}$";

    public final String tutorialName;
    private final ArrayList<Person> students;
    /**
     * Constructs a {@code TutorialClass} with default values.
     * Initializes the {@code value} field to an empty string and creates an empty list for {@code students}.
     */
    public TutorialClass() {
        this.tutorialName = "";
        this.students = new ArrayList<>();
    }


    /**
     * A constructor for TutorialClass. Creates an empty tutorial class with no
     * students.
     * @param name of tutorial to be added
     */
    public TutorialClass(String tutorialClass) {
        requireAllNonNull(tutorialClass);
        checkArgument(isValidTutorialClass(tutorialClass), MESSAGE_CONSTRAINTS);
        this.tutorialName = tutorialClass;
        this.students = new ArrayList<>();
    }

    /**
     * A constructor for TutorialClass. Creates a tutorial with the list of students
     * specified.
     * @param name     of tutorial to be added
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
    /**
     * Retrieves the tutorial class.
     *
     * @return The tutorial class.
     */
    public TutorialClass getTutorialClass() {
        return this;
    }
    /**
     * Retrieves the list of students in the tutorial class.
     *
     * @return The list of students in the tutorial class.
     */
    public ArrayList<Person> getStudents() {
        return this.students;
    }

    /**
     * Adds a student to the tutorial class.
     */
    public void addStudent(Person student) {
        students.add(student);

    }

    /**
     * Checks if the student is in the tutorial class.
     * @param student
     * @return true if the student is in the tutorial class
     */
    public boolean hasStudent(Person student) {
        return students.contains(student);
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
