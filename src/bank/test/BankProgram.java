package bank.test;

import java.util.Scanner;

public class BankProgram {
    public static Scanner sc = new Scanner(System.in);
    public static Company companyarray[] = new Company[50]; //회사계정으로 사용할 클래스배열초기화
    public static Person personarray[] = new Person[50]; //개인계정으로 사용할 클래스배열 초기화

    public static void main(String[] args) {

        boolean run = true; //콘솔에 종료하기전까지 반복하기위해 반복문제어변수초기화
        while (run) { // run이 false가 되기 전까지는 반복
            mainsreen();//메인화면을 띄우는 함수
            int selectNo = sc.nextInt();// 콘솔창에서 숫자를 입력받아 기능을 사용
            if (selectNo == 1) {
                createAccount();// 1을 누르면 계정을 만드는 함수
            } else if (selectNo == 2) {
                accountlist();  //2를 누르면 계정list를 나열하는 함수
            } else if (selectNo == 3) {
                input();        //3을 누르면 입금기능을 수행할 함수
            } else if (selectNo == 4) {
                output();       //4를 누르면 출금기능을 수행할 함수
            } else if (selectNo == 5) {
                send();         //5를 누르면 계정이 존재하는 상대에서 금액을 전송할 함수
            } else if (selectNo == 6) {
                run = false;    //6을 누르면 제어변수를 false로 만들어 프로그램을 종료하고 종료구문 출력
                System.out.println("프로그램이 종료됩니다.");
            }

        }
    }
//    다음 각 함수를 코딩했습니다.
//
//            ​
//
//    먼저 mainscreen() 함수 -> 콘솔에 인터페이스 출력

    private static void mainsreen() { //콘솔에 인터페이스 출력
        System.out.println("-------------------------------------------");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.계좌이체|6종료");
        System.out.println("-------------------------------------------|");
        System.out.print("선택>");

    }
//    createAccount() 함수 -> 계정을 생성하는 함수
//
//    숫자를 입력받아 원하는 종류의 계정을 만들수 있게 코딩

    private static void createAccount() {
        System.out.println("---------------------------");
        System.out.println("1.회사계좌생성|2.개인계좌생성");
        System.out.println("---------------------------");
        System.out.print("선택>");
        int selectNo = sc.nextInt(); //숫자를 택하여 만들고 싶은 계정을 선택
        if (selectNo == 1) {  //각 변수에 정보를 받는 과정
            System.out.println("회사계좌");
            System.out.print("계좌번호:");
            String ano = sc.next();
            System.out.print("패스워드:");
            String password = sc.next();
            System.out.print("회사명:");
            String companyname = sc.next();
            System.out.print("초기입금액:");
            int money = sc.nextInt();

            for (int i = 0; i < companyarray.length; i++) { //배열에 같은 계정가 있는지 확인하는 과정
                if (companyarray[i] != null) {
                    if (companyarray[i].getAno().equals(ano)) {
                        System.out.println("이미 있는 계정입니다.");
                        return;
                    }

                } else { //같은 계정이 없다면 for문 탈출
                    break;
                }
            }


            for (int i = 0; i < companyarray.length; i++) { //반복문을 이용하여 배열의 빈공간을 찾기
                if (companyarray[i] == null) { //비어있다면 i번째에
                    companyarray[i] = new Company(); //객체를 생성
                    companyarray[i].setAno(ano);   //생성한 객체에 세터 개터를 이용하여 정보입력
                    companyarray[i].setPassword(password);
                    companyarray[i].setComanyname(companyname);
                    companyarray[i].setCompanybalance(money);
                    companyarray[i].createaccount(ano);
                    break;
                }

            }
        } else if (selectNo == 2) { // 2를 누르면 개인계정이 만들수있게 위의 코드와 똑같이 코딩
            System.out.println("개인계좌");
            System.out.print("계좌번호:");
            String ano = sc.next();
            System.out.print("패스워드:");
            String password = sc.next();
            System.out.print("계좌주이름:");
            String personname = sc.next();
            System.out.print("초기입금액:");
            int money = sc.nextInt();

            for (int i = 0; i < personarray.length; i++) {
                if (personarray[i] != null) {
                    if (personarray[i].getAno().equals(ano)) {
                        System.out.println("이미 있는 계정입니다.");
                        return;
                    }

                } else {
                    break;
                }
            }


            for (int i = 0; i < personarray.length; i++) {
                if (personarray[i] == null) {
                    personarray[i] = new Person();
                    personarray[i].setAno(ano);
                    personarray[i].setPassword(password);
                    personarray[i].setPersonname(personname);
                    personarray[i].setPersonbalance(money);
                    personarray[i].createaccount(ano);
                    break;

                }

            }
        } else {
            return;
        }

    }
//    accountlist() 함수 -> 반복문으로 배열에 들어있는 객체의 정보를 콘솔창에 출력

    private static void accountlist() {
        System.out.print("1.회사계좌|2.개인계좌");
        int selectNo = sc.nextInt();
        if (selectNo == 1) {
            System.out.println("회사계좌");
            System.out.println("회사명     계좌번호   잔액");
            for (int i = 0; i < companyarray.length; i++) {
                if (companyarray[i] != null) {
                    System.out.print(companyarray[i].getComanyname());
                    System.out.print("     ");
                    System.out.print(companyarray[i].getAno());
                    System.out.print("    ");
                    System.out.println(companyarray[i].getCompanybalance());
                    System.out.println();
                }
            }
        } else if (selectNo == 2) {
            System.out.println("개인계좌");
            System.out.println("이름     계좌번호   잔액");
            for (int i = 0; i < personarray.length; i++) {
                if (personarray[i] != null) {
                    System.out.print(personarray[i].getPersonname());
                    System.out.print("     ");
                    System.out.print(personarray[i].getAno());
                    System.out.print("  ");
                    System.out.print(personarray[i].getPersonbalance());
                    System.out.println();
                }
            }

        } else {
            return;
        }
    }
//    input()함수 -> 계정을 선택해서 각 계정의 잔액을 변경처리(+)하는 함수

    private static void input() {
        System.out.println("입금할 계정종류");
        System.out.println("1.회사계좌|2.개인계좌");
        int selectNo = sc.nextInt();
        if (selectNo == 1) {
            System.out.println("입금할 회사계좌 :");
            String ano = sc.next();
            System.out.println("입금할 금액");
            int money = sc.nextInt();
            for (int i = 0; i < companyarray.length; i++) {
                if (companyarray[i] != null) {//반복문을 이용하여 비어있지않은 배열을 찾는다
                    if (companyarray[i].getAno().equals(ano)) { // 비어있지않은 배열을 찾은 다음 입금할 계정이 있는지 확인
                        companyarray[i].setCompanybalance(companyarray[i].getCompanybalance() + money);//계정이 있다면 원래있던 잔액과 입금할 금액을 +처리
                        System.out.println("입금이 완료되었습니다.");
                        System.out.println("회사계좌:" + companyarray[i].getAno() + "의잔액 :" + companyarray[i].getCompanybalance());
                        return;
                    } else {

                    }
                } else {

                }

            }
            System.out.println("입금실패");
        } else if (selectNo == 2) {
            System.out.println("입금할 개인계좌 :");
            String ano = sc.next();
            System.out.println("입금할 금액");
            int money = sc.nextInt();
            for (int i = 0; i < personarray.length; i++) {
                if (personarray[i] != null) {
                    if ((personarray[i].getAno()).equals(ano)) {
                        personarray[i].setPersonbalance(personarray[i].getPersonbalance() + money);
                        System.out.println("입금이 완료되었습니다.");
                        System.out.println("개인계좌" + personarray[i].getAno() + "의잔액 :" + personarray[i].getPersonbalance());
                        return;
                    } else {

                    }
                } else {

                }

            }
            System.out.println("입금실패");

        } else {
            return;
        }

    }
//    output()함수 -> input함수와 유사하지만 -처리를 하고  비밀번호를 입력하여 확인한 다음 잔금이 출금할 금액보다 작으면 함수에서 빠져나오는 기능이 추가

    private static void output() {
        System.out.println("출금할 계정종류");
        System.out.println("1.회사계좌|2.개인계좌");
        int selectNo = sc.nextInt();
        if (selectNo == 1) {
            System.out.println("출금할 회사계좌 :");
            String ano = sc.next();
            System.out.println("비밀번호:");
            String password = sc.next();
            System.out.println("출금할 금액");
            int money = sc.nextInt();

            for (int i = 0; i < companyarray.length; i++) {
                if (companyarray[i] != null) {
                    if (companyarray[i].getAno().equals(ano)) {
                        if (companyarray[i].getCompanybalance() < money) {
                            System.out.println("잔액이 부족합니다.");
                            return;
                        } else {
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < companyarray.length; i++) {
                if (companyarray[i].getPassword().equals(password)) {
                    if (companyarray[i] != null) {
                        if (companyarray[i].getAno().equals(ano)) {
                            companyarray[i].setCompanybalance(companyarray[i].getCompanybalance() - money);
                            System.out.println("출금이 완료되었습니다.");
                            System.out.println("회사계좌:" + companyarray[i].getAno() + "의잔액 :" + companyarray[i].getCompanybalance());
                            return;
                        } else {

                        }
                    } else {

                    }

                } else {
                    System.out.println("비밀번호가 틀립니다.");
                    return;
                }
            }


        } else if (selectNo == 2) {
            System.out.println("출금할 개인계좌 :");
            String ano = sc.next();
            System.out.println("비밀번호:");
            String password = sc.next();
            System.out.println("출금할 금액");
            int money = sc.nextInt();

            for (int i = 0; i < personarray.length; i++) { //출금기능을 처리하기전 아이디를 검색하여 잔금과 출금할 금액을 비교
                if (personarray[i] != null) {
                    if (personarray[i].getAno().equals(ano)) {
                        if (personarray[i].getPersonbalance() < money) { //잔금이 출금할 금액보다 작다면 기능 취소
                            System.out.println("잔액이 부족합니다.");
                            return;
                        } else {
                            break;
                        }
                    }
                }
            }


            for (int i = 0; i < personarray.length; i++) { //아이디와 비밀번호를 확인 하여 처리
                if (personarray[i].getPassword().equals(password)) {
                    if (personarray[i] != null) {
                        if ((personarray[i].getAno()).equals(ano)) {
                            personarray[i].setPersonbalance(personarray[i].getPersonbalance() - money);
                            System.out.println("출금이 완료되었습니다.");
                            System.out.println("개인계좌" + personarray[i].getAno() + "의잔액 :" + personarray[i].getPersonbalance());
                            return;
                        } else {

                        }
                    } else {

                    }

                } else {
                    System.out.println("비밀번호가 틀립니다.");
                    return;
                }
            }

        } else {
            return;
        }

    }
//    send()함수 -> 계정이 존재하는 상대방에게 금액을 전송처리하는 함수
//
//    현재 사용하고 있는 계정에서는 -처리
//
//    상대방계정에서는 +처리를 하여야 한다.
//
//    코드가 길어진 이유는 계정종류가 다른 계정에서도 서로 처리할수 있도록 코딩

    private static void send() {
        System.out.println("보내는 계정종류");
        System.out.println("1.회사계좌|2.개인계좌");
        int sendcompany = 0;
        int receivecompany = 0;
        int sendperson = 0;
        int receiveperson = 0;
        int sendmoney;
        int selectNo = sc.nextInt();
        if (selectNo == 1) {
            System.out.print("보내는 회사계좌 :");
            String ano = sc.next();
            System.out.print("보낼금액 :");
            sendmoney = sc.nextInt();
            for (int i = 0; i < companyarray.length; i++) { //사용할계정을 조회하여 존재한다면 sendcompany 라는 변수에  배열의 인덱스를 저장
                if (companyarray[i] != null) {
                    if (companyarray[i].getAno().equals(ano)) {
                        sendcompany = i;
                        break;
                    } else {


                    }
                } else { //존재하지않으면 함수탈출
                    System.out.println("계좌가 없습니다.");
                    return;
                }
            }
            System.out.println("받는 계정종류");
            System.out.println("1.회사계좌|2.개인계좌");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                System.out.println("받는 회사계좌 :");
                ano = sc.next();
                for (int i = 0; i < companyarray.length; i++) { //돈을 받음 계정을 검새하여 존재한다면 receivecompany라는 변수에 인덱스를 저장
                    if (companyarray[i] != null) {
                        if (companyarray[i].getAno().equals(ano)) {
                            receivecompany = i;
                            break;
                        } else {

                        }
                    } else {
                        System.out.println("계좌가 없습니다.");
                        return;
                    }
                }
                companyarray[sendcompany].setCompanybalance(companyarray[sendcompany].getCompanybalance() - sendmoney); //보내는 계정에서 -처리
                companyarray[receivecompany].setCompanybalance(companyarray[receivecompany].getCompanybalance() + sendmoney);//받는 계정에서 +처리
                System.out.println("회사계정" + companyarray[sendcompany].getAno() + "잔액 :" + companyarray[sendcompany].getCompanybalance()); //처리한 값을 출력
                System.out.println("회사계정" + companyarray[receivecompany].getAno() + "잔액 :" + companyarray[receivecompany].getCompanybalance());//처리한 값을 출력

            } else if (selectNo == 2) {
                System.out.println("받는 개인계좌 :");
                ano = sc.next();
                for (int i = 0; i < personarray.length; i++) {
                    if (personarray[i] != null) {
                        if (personarray[i].getAno().equals(ano)) {
                            receiveperson = i;
                            break;
                        } else {


                        }
                    } else {
                        System.out.println("계좌가 없습니다.");
                        return;
                    }

                }
                companyarray[sendcompany].setCompanybalance(companyarray[sendcompany].getCompanybalance() - sendmoney);
                personarray[receiveperson].setPersonbalance(personarray[receiveperson].getPersonbalance() + sendmoney);
                System.out.println("회사계정" + companyarray[sendcompany].getAno() + "잔액 :" + companyarray[sendcompany].getCompanybalance());
                System.out.println("개인계정" + personarray[receiveperson].getAno() + "잔액 :" + personarray[receiveperson].getPersonbalance());
                // 회사 -----회사,개인

            } else {
                return;
            }
        } else if (selectNo == 2) {
            System.out.print("보내는 개인계좌 :");
            String ano = sc.next();
            System.out.print("보낼금액 :");
            sendmoney = sc.nextInt();
            for (int i = 0; i < personarray.length; i++) {
                if (personarray[i] != null) {
                    if (personarray[i].getAno().equals(ano)) {
                        sendperson = i;
                        break;
                    } else {


                    }
                } else {
                    System.out.println("계좌가 없습니다.");
                    return;
                }
            }
            System.out.println("받는 계정종류");
            System.out.println("1.회사계좌|2.개인계좌");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                System.out.println("받는 회사계좌 :");
                ano = sc.next();
                for (int i = 0; i < companyarray.length; i++) {
                    if (companyarray[i] != null) {
                        if (companyarray[i].getAno().equals(ano)) {
                            receivecompany = i;
                            break;
                        } else {

                        }
                    } else {
                        System.out.println("계좌가 없습니다.");
                        return;
                    }
                }
                personarray[sendperson].setPersonbalance(personarray[sendperson].getPersonbalance() - sendmoney);
                companyarray[receivecompany].setCompanybalance(companyarray[receivecompany].getCompanybalance() + sendmoney);
                System.out.println("개인계정" + personarray[sendperson].getAno() + "잔액 :" + personarray[sendperson].getPersonbalance());
                System.out.println("회사계정" + companyarray[receivecompany].getAno() + "잔액 :" + companyarray[receivecompany].getCompanybalance());

            } else if (selectNo == 2) {
                System.out.println("받는 개인계좌 :");
                ano = sc.next();
                for (int i = 0; i < personarray.length; i++) {
                    if (personarray[i] != null) {
                        if (personarray[i].getAno().equals(ano)) {
                            receiveperson = i;
                            break;
                        } else {


                        }
                    } else {
                        System.out.println("계좌가 없습니다.");
                        return;
                    }

                }
                personarray[sendperson].setPersonbalance(personarray[sendperson].getPersonbalance() - sendmoney);
                personarray[receiveperson].setPersonbalance(personarray[receiveperson].getPersonbalance() + sendmoney);
                System.out.println("개인계정" + personarray[sendperson].getAno() + "잔액 :" + personarray[sendperson].getPersonbalance());
                System.out.println("개인계정" + personarray[receiveperson].getAno() + "잔액 :" + personarray[receiveperson].getPersonbalance());
                // 개인 -----회사,개인

            } else {
                return;
            }
        } else {
            return;
        }


    }
}
