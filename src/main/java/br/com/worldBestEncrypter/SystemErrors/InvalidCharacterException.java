package br.com.worldBestEncrypter.SystemErrors;

public class InvalidCharacterException extends Exception{
    public InvalidCharacterException(){
        super();
    }

    public InvalidCharacterException(String message){
        super(message);
    }

    public InvalidCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCharacterException(Throwable cause) {
        super(cause);
    }
}
