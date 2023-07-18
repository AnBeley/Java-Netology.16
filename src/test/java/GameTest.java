import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWins() {
        Player first = new Player(1, "Первый", 100);
        Player second = new Player(2, "Второй", 50);
        Game game = new Game();

        game.register(first);
        game.register(second);
        int actual = game.round("Первый", "Второй");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerWins() {
        Player first = new Player(1, "Первый", 50);
        Player second = new Player(2, "Второй", 100);
        Game game = new Game();

        game.register(first);
        game.register(second);
        int actual = game.round("Первый", "Второй");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void nobodyWins() {
        Player first = new Player(1, "Первый", 100);
        Player second = new Player(2, "Второй", 100);
        Game game = new Game();

        game.register(first);
        game.register(second);
        int actual = game.round("Первый", "Второй");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void notRegisteredExceptionTestIfOnlyFirst() {
        Player first = new Player(1, "Первый", 100);
        Player second = new Player(2, "Второй", 100);
        Game game = new Game();

        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Первый", "Третий"));

    }

    @Test
    public void notRegisteredExceptionIfOnlySecond() {
        Player first = new Player(1, "Первый", 100);
        Player second = new Player(2, "Второй", 100);
        Game game = new Game();

        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Третий", "Второй"));

    }

    @Test
    public void notRegisteredExceptionIfBoth() {
        Player first = new Player(1, "Первый", 100);
        Player second = new Player(2, "Второй", 100);
        Game game = new Game();

        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Третий", "Четвертый"));

    }
}