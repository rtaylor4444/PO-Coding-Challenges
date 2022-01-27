package pojan242022;

public class ValidPin {
    public boolean isValid(String pin){
        return pin.matches("[0-9]{4}|[0-9]{6}");
    }
    public static void main(String[] args) {
        ValidPin validator = new ValidPin();
        System.out.println(validator.isValid("121317"));
        System.out.println(validator.isValid("1234"));
        System.out.println(validator.isValid("45135"));
        System.out.println(validator.isValid("89abc1"));
        System.out.println(validator.isValid("900876"));
        System.out.println(validator.isValid(" 4983"));
    }
}
