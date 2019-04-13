package domain.bridge;

/**
 * 의존 역전 원칙 : http://wonwoo.ml/index.php/post/1717
 * 개방 폐쇠 원칙 : http://wonwoo.ml/index.php/post/1726
 */

public interface BridgeGenerator {
    public boolean generate(boolean left);
}
