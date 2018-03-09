public class DateValidator {
    public static boolean validate(String date) {
        if(date.isEmpty()) {
            return false;
        }

        Integer intDate = Integer.valueOf(date);

        if(intDate < 199001 || intDate > 204912) {
            throw new IllegalArgumentException("validate date");
        }

        return true;
    }
}
