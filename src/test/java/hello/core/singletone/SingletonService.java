package hello.core.singletone;

public class SingletonService {
    
    // 1개만 존재하는 객체 (static)
    public static final SingletonService instance = new SingletonService();

    // 자기자신을 객체 인스턴스로 갖고 있는다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성 못하게 막는다.
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
