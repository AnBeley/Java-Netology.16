public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String player) {

        super(" Игрок под именем " + player + " не обнаружен");
    }


}
