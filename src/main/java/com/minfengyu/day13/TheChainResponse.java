package com.minfengyu.day13;

public class TheChainResponse {

    private static AuthenticationProcess getChainOfAuthProcessor(){
        OAuthProcess oAuthProcess = new OAuthProcess(null);
        return new UsernamePasswordProcessor(oAuthProcess);

    }



    public static void main(String[] args) {
        UsernamePasswordProcessor usernamePasswordProcessor = new UsernamePasswordProcessor(null);
        AuthenticationProcess usernamePasswordProcessor1 = new OAuthProcess(usernamePasswordProcessor);


    }
}
abstract class AuthenticationProcess{
    public AuthenticationProcess nextProcess;

    public AuthenticationProcess(AuthenticationProcess nextProcess) {
        this.nextProcess = nextProcess;
    }

    public abstract boolean isAuthorized(AuthenticationProcess authenticationProcess);
}
 class OAuthProcess extends AuthenticationProcess{
    public OAuthProcess(AuthenticationProcess nextProcess) {
        super(nextProcess);
    }

    @Override
    public boolean isAuthorized(AuthenticationProcess authenticationProcess) {
        if (authenticationProcess instanceof OAuthProcess){
            return  true;
        }else  if (nextProcess!=null){
            return nextProcess.isAuthorized(authenticationProcess);
        }
        return false;
    }
}
class UsernamePasswordProcessor extends AuthenticationProcess{

    public UsernamePasswordProcessor(AuthenticationProcess nextProcess) {
        super(nextProcess);
    }

    @Override
    public boolean isAuthorized(AuthenticationProcess authenticationProcess) {
        System.out.println(authenticationProcess);
        if (authenticationProcess instanceof UsernamePasswordProcessor){
            return  true;
        }else  if (nextProcess!=null){
            return nextProcess.isAuthorized(authenticationProcess);
        }
        return false;
    }
}