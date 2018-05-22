package sample.pohinian.springvue.member;

/**
 * Created by Park Ji Hoon (pohinian@gmail.com) on 2018. 4. 16..
 */
public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String exception) {
        super(exception);
    }
}
