package com.pb.gvozdev.hw8;

public class Auth {

    private String login;
    private String password;

    String regexLogin = "^[A-Za-z0-9]{5,20}$";
    String regexPassword = "^\\w{5,50}$";

    public void signUp(String login,
                       String password,
                       String confirmPassword) throws WrongPasswordException, WrongLoginException {

        if (!checkLogin(login)) {
            throw new WrongLoginException();
        }

        if (!checkPassword(password)) {
            throw new WrongPasswordException("Wrong confirm password!");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }

        this.login = login;
        this.password = password;

    }

    public boolean checkLogin(String login){
      return login.matches(regexLogin);
    }

    public boolean checkPassword(String password){
        return password.matches(regexPassword);
    }

    public void sigIn(String login, String password) throws WrongLoginException{
         if(login.equals(this.login) && password.equals(this.password))
             return;
         throw new WrongLoginException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auth auth = (Auth) o;
        return login.equals(auth.login) && password.equals(auth.password);
    }

}