package bank.test;

public class Person extends BankAccount {
    private String personname; //상속받는 변수와 별개로
    private int personbalance; // 클래스에서 추가로 사용할 변수 코딩

    public String getPersonname() { //세터와 개터
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public int getPersonbalance() {
        return personbalance;
    }

    public void setPersonbalance(int personbalance) {
        this.personbalance = personbalance;
    }

    @Override //상위클래스에 있는 메소드를 오버라이딩 하여 사용
    public void createaccount(String ano) {
        System.out.println("계좌번호가" + ano + "인 개인계좌를 생성하였습니다.");
    }


}
