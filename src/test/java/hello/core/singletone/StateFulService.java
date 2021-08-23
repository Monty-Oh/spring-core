package hello.core.singletone;

class StateFulService {

    private int price;  // 상태를 유지하는 필드드

    public void order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price; // 여기가 문제!!
//        return price;
    }

    public int getPrice() {
        return price;
    }
}
