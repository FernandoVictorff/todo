package br.com.fernando.test.todo.validator;

public class ValidatorConstants {

    public static final String TASK_ID = "id";
    public static final String TASK_TITLE = "title";
    public static final String TASK_DESCRIPTION = "description";


    public static final int TASK_TITLE_MAX_LENGTH = 60;
    public static final int TASK_DESCRIPTION_MAX_LENGTH = 150;


    public static final String MISSING = ".missing";
    public static final String EXCEEDS_MAX_LENGTH = ".exceedsMaxLength";

    private ValidatorConstants() {}
}
