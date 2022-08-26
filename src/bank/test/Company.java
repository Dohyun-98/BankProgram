package bank.test;

public class Company extends BankAccount {
    private String Comanyname; //상속받는 변수와 별개로
    private int Companybalance;//하위 클래스에서 추가로 사용할 변수코딩


    public String getComanyname() {//추상클래스와 마찬가지로 세터와 개터 설정
        return Comanyname;
    }


    public void setComanyname(String comanyname) {
        Comanyname = comanyname;
    }


    public int getCompanybalance() {
        return Companybalance;
    }


    public void setCompanybalance(int companybalance) {
        Companybalance = companybalance;
    }


    @Override //추상클래스에 있는 메소드를 오버라이딩하여 사용
    public void createaccount(String ano) {
        System.out.println("계좌번호가" + ano + "인 회사계좌를 생성하였습니다");
    }


}
