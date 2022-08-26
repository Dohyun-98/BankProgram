package bank.test;

public abstract class BankAccount {
    private String ano; // 모든계좌에는 계좌번호와 비밀번호가 있기 때문에
    private String password; // 추상클래스에서 변수 설정

    BankAccount() {

    }

    public String getAno() { //private 형식이기 때문에 각 변수에 세터와 개터 코딩
        return ano;
    }


    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void createaccount(String ano); //추상메소드를 상속받는 클래스에서 오버로딩하여 콘솔에 계정을 생성하였는다는 구문을 출력


}
