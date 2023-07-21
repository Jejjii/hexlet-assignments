package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> validate(Object object) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if (value == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }
}
